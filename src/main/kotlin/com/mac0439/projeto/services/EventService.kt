package com.mac0439.projeto.services

import com.mac0439.projeto.domain.mongo.event.Event
import com.mac0439.projeto.domain.mongo.repositories.EventRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class EventService(private val repository: EventRepository) {
    fun findById(id: String): Event {
        val event = repository.findById(id)
        if (event.isEmpty) throw Exception("Publication not found")
        return event.get()
    }

    fun deleteById(id: String) {
        repository.deleteById(id)
    }

    fun addEvent(event: Event): Event {
        return repository.save(event) // TODO: Change name for this and for the publication one
    }

    fun updateEvent(event: Event) {
        repository.updateEvent(event)
    }
}
