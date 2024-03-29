package com.mac0439.projeto.domain.mongo.repositories

import com.mac0439.projeto.domain.mongo.publication.Comment
import com.mac0439.projeto.domain.mongo.publication.Publication
import com.mongodb.BasicDBObject
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.stereotype.Repository

@Repository
class PublicationCustomRepositoryImpl(private val mongoOperations: MongoOperations) : PublicationCustomRepository {
    override fun updatePublication(publication: Publication) {
        val query = Query().addCriteria((Criteria.where("_id")).isEqualTo(publication.id))
        val update = Update()
            .set("title", publication.title)
            .set("text", publication.text)
        val result = mongoOperations.updateFirst(query, update, Publication::class.java)
        if (result.matchedCount != 1L) {
            throw Exception("Publication update had ${result.matchedCount} matches")
        }
    }

    fun getCommentByIdQuery(pid: String, cmid: String): Query {
        return Query()
            .addCriteria(Criteria.where("_id").isEqualTo(pid))
            .addCriteria(Criteria.where("comments._id").isEqualTo(cmid))
    }

    override fun findCommentById(pid: String, cmid: String): Comment {
        val query = getCommentByIdQuery(pid, cmid)
        query.fields().position("comments.\$", 1)

        val publication = mongoOperations.findOne(query, Publication::class.java) ?: throw Exception("Publication not found")

        if (publication.comments == null) throw Exception("Comment not found")

        if (publication.comments.size != 1) throw Exception("The comment is not unique")

        return publication.comments[0]
    }

    override fun addComment(pid: String, comment: Comment) {
        val query = Query().addCriteria(Criteria.where("_id").isEqualTo(pid))
        val update = Update().push("comments", comment)
        val result = mongoOperations.updateFirst(query, update, Publication::class.java)
        if (result.modifiedCount != 1L) {
            throw Exception("Comment addition caused ${result.modifiedCount} modifications")
        }
    }

    override fun updateComment(pid: String, comment: Comment) {
        if (comment.id == null) throw Exception("Null comment id")
        val query = getCommentByIdQuery(pid, comment.id)
        val update = Update().set("comments.\$.text", comment.text ?: "")
        val result = mongoOperations.updateFirst(query, update, Publication::class.java)
        if (result.matchedCount != 1L) {
            throw Exception("Comment update had ${result.matchedCount} matches")
        }
    }

    override fun addLikeToComment(pid: String, cmid: String, user: String) {
        val query = getCommentByIdQuery(pid, cmid)
        val update = Update().addToSet("comments.\$.likes", user)
        val result = mongoOperations.updateFirst(query, update, Publication::class.java)
        if (result.matchedCount != 1L) {
            throw Exception("Comment like addition had ${result.matchedCount} matches")
        }
    }
    override fun removeLikeFromComment(pid: String, cmid: String, user: String) {
        val query = getCommentByIdQuery(pid, cmid)
        val update = Update().pull("comments.\$.likes", user)
        val result = mongoOperations.updateFirst(query, update, Publication::class.java)
        if (result.matchedCount != 1L) {
            throw Exception("Comment like removal had ${result.matchedCount} matches")
        }
    }

    override fun deleteComment(pid: String, cmid: String) {
        val query = Query().addCriteria((Criteria.where("_id")).isEqualTo(pid))
        val update = Update().pull("comments", BasicDBObject("_id", cmid))
        val result = mongoOperations.updateFirst(query, update, Publication::class.java)
        if (result.modifiedCount != 1L) {
            throw Exception("Comment deletion caused ${result.modifiedCount} modifications")
        }
    }
}
