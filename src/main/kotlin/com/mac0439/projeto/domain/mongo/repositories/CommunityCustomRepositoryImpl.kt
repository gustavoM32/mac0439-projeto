package com.mac0439.projeto.domain.mongo.repositories

import com.mac0439.projeto.domain.mongo.community.Community
import com.mac0439.projeto.domain.mongo.event.Event
import com.mac0439.projeto.domain.mongo.publication.Publication
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.stereotype.Repository

@Repository
class CommunityCustomRepositoryImpl(private val mongoOperations: MongoOperations) : CommunityCustomRepository {
    override fun updateCommunity(community: Community) {
        val query = Query().addCriteria((Criteria.where("_id")).isEqualTo(community.id))
        val update = Update()
            .set("name", community.name)
            .set("description", community.description)
        val result = mongoOperations.updateFirst(query, update, Community::class.java)
        if (result.matchedCount != 1L) {
            throw Exception("Community update had ${result.matchedCount} matches")
        }
    }

    override fun addPublication(cid: String, publication: Publication) {
        val query = Query().addCriteria((Criteria.where("_id")).isEqualTo(cid))
        val update = Update().push("publications", publication)
        val result = mongoOperations.updateFirst(query, update, Community::class.java)
        if (result.modifiedCount != 1L) {
            throw Exception("Publication addition caused ${result.modifiedCount} modifications")
        }
    }

    override fun deletePublication(cid: String, pid: String) {
        val query = Query().addCriteria((Criteria.where("_id")).isEqualTo(cid))
        val update = Update().pull("publications", pid)
        val result = mongoOperations.updateFirst(query, update, Community::class.java)
        if (result.modifiedCount != 1L) {
            throw Exception("Publication deletion caused ${result.modifiedCount} modifications")
        }
    }

    override fun addEvent(cid: String, event: Event) {
        val query = Query().addCriteria((Criteria.where("_id")).isEqualTo(cid))
        val update = Update().push("events", event)
        val result = mongoOperations.updateFirst(query, update, Community::class.java)
        if (result.modifiedCount != 1L) {
            throw Exception("Event addition caused ${result.modifiedCount} modifications")
        }
    }

    override fun deleteEvent(cid: String, eid: String) {
        val query = Query().addCriteria((Criteria.where("_id")).isEqualTo(cid))
        val update = Update().pull("events", eid)
        val result = mongoOperations.updateFirst(query, update, Community::class.java)
        if (result.modifiedCount != 1L) {
            throw Exception("Event deletion caused ${result.modifiedCount} modifications")
        }
    }
}
