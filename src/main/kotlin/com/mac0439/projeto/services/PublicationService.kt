package com.mac0439.projeto.services

import com.mac0439.projeto.domain.mongo.publication.Publication
import com.mac0439.projeto.domain.mongo.repositories.PublicationRepository
import org.springframework.stereotype.Service

@Service
class PublicationService(private val repository: PublicationRepository) {
    fun addPublication(publication: Publication): Publication {
        return repository.save(publication)
    }
}
