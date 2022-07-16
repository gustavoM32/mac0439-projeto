package com.mac0439.projeto.domain.mongo.repositories

import com.mac0439.projeto.domain.mongo.publication.Comment
import com.mac0439.projeto.domain.mongo.publication.Publication
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.stereotype.Repository

@Repository
class PublicationCustomRepositoryImpl(private val mongoOperations: MongoOperations) : PublicationCustomRepository {
    override fun addComment(publication: String, comment: Comment) {
        val query = Query().addCriteria((Criteria.where("_id")).isEqualTo(publication))
        val update = Update().push("comments", comment)
        mongoOperations.updateFirst(query, update, Publication::class.java)
    }
}
