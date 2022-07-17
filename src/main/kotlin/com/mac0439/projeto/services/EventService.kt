package com.mac0439.projeto.services

import com.mac0439.projeto.domain.mongo.repositories.EventRepository
import org.springframework.stereotype.Service

@Service
class EventService(private val repository: EventRepository) {
    fun deleteById(id: String) {
        repository.deleteById(id)
    }
}
