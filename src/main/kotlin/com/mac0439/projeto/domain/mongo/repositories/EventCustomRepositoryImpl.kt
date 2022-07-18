package com.mac0439.projeto.domain.mongo.repositories

import com.mac0439.projeto.domain.mongo.event.Event
import com.mac0439.projeto.domain.mongo.publication.Publication
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.stereotype.Repository

@Repository
class EventCustomRepositoryImpl(private val mongoOperations: MongoOperations) : EventCustomRepository {
    override fun updateEvent(event: Event) {
        val query = Query().addCriteria((Criteria.where("_id")).isEqualTo(event.id))
        val update = Update()
            .set("title", event.title)
            .set("description", event.description)
            .set("date", event.date)
            .set("estimatedDuration", event.estimatedDuration)
        val result = mongoOperations.updateFirst(query, update, Event::class.java)
        if (result.matchedCount != 1L) {
            throw Exception("Event update had ${result.matchedCount} matches")
        }
    }
}
