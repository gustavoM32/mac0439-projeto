package com.mac0439.projeto.services

import com.mac0439.projeto.domain.mongo.publication.Comment
import com.mac0439.projeto.domain.mongo.publication.Publication
import com.mac0439.projeto.domain.mongo.repositories.PublicationRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class PublicationService(private val repository: PublicationRepository) {
    fun findById(id: String): Publication {
        val publication = repository.findById(id)
        if (publication.isEmpty) throw Exception("Publication not found")
        return publication.get()
    }

    fun addPublication(publication: Publication): Publication {
        publication.creationDate = LocalDateTime.now()
        return repository.save(publication)
    }

    fun deletePublication(id: String) {
        repository.deleteById(id)
    }

    fun addComment(pid: String, comment: Comment) {
        comment.creationDate = LocalDateTime.now()
        repository.addComment(pid, comment)
    }

    fun deleteComment(pid: String, cmid: String) {
        repository.deleteComment(pid, cmid)
    }
}
