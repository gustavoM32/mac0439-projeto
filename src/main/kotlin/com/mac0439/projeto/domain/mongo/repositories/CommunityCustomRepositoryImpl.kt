package com.mac0439.projeto.domain.mongo.repositories

import com.mac0439.projeto.domain.mongo.community.Community
import com.mac0439.projeto.domain.mongo.publication.Publication
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.stereotype.Repository

@Repository
class CommunityCustomRepositoryImpl(private val mongoOperations: MongoOperations) : CommunityCustomRepository {
    override fun addPublication(community: String, publication: Publication) {
        val query = Query().addCriteria((Criteria.where("_id")).isEqualTo(community))
        val update = Update().push("publications", publication)
        val result = mongoOperations.updateFirst(query, update, Community::class.java)
        if (result.modifiedCount != 1L) {
            throw Exception("Publication addition caused ${result.modifiedCount} modifications")
        }
    }
}
