package com.mac0439.projeto.services

import com.mac0439.projeto.domain.mongo.publication.Comment
import com.mac0439.projeto.domain.mongo.publication.Publication
import com.mac0439.projeto.domain.mongo.repositories.PublicationRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PublicationService(private val repository: PublicationRepository) {
    fun findById(id: String): Optional<Publication> {
        return repository.findById(id)
    }

    fun addPublication(publication: Publication): Publication {
        return repository.save(publication)
    }

    fun deleteById(id: String) {
        repository.deleteById(id)
    }

    fun addComment(pid: String, comment: Comment) {
        repository.addComment(pid, comment)
    }
}
