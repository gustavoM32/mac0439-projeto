package com.mac0439.projeto.services

import com.mac0439.projeto.domain.mongo.community.Community
import com.mac0439.projeto.domain.mongo.event.Event
import com.mac0439.projeto.domain.mongo.publication.Publication
import com.mac0439.projeto.domain.mongo.repositories.CommunityRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class CommunityService(
    private val repository: CommunityRepository,
    private val publicationService: PublicationService,
    private val eventService: EventService
    ) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    fun findAll(): List<Community> {
        return repository.findAll()
    }

    fun findById(id: String): Community {
        val community = repository.findById(id)
        if (community.isEmpty) throw Exception("Community not found")
        return community.get()
    }

    fun addCommunity(community: Community): Community {
        community.creationDate = LocalDateTime.now()
        return repository.save(community)
    }

    fun updateCommunity(community: Community) {
        repository.updateCommunity(community)
    }

    @Throws(Exception::class)
    fun deleteCommunity(id: String) {
        val community: Community

        try {
            community = this.findById(id)
        } catch (e: Exception) {
            logger.error(e.toString())
            throw Exception("Community to delete not found")
        }

        // TODO: community deletion should delete its projects

        // community deletion should delete its events
        community.events?.let {
            for (e: Event in it) {
                checkNotNull(e.id)
                eventService.deleteById(e.id)
            }
        }

        // community deletion should delete its publications
        community.publications?.let {
            for (p: Publication in it) {
                checkNotNull(p.id)
                publicationService.deleteById(p.id)
            }
        }

        repository.deleteById(id)
    }

    fun addPublication(cid: String, publication: Publication) {
        val newPublication = publicationService.addPublication(publication)
        repository.addPublication(cid, newPublication)
    }

    fun deletePublication(cid: String, pid: String) {
        try {
            // publication deletion should delete its reference from the community
            repository.deletePublication(cid, pid)
        } catch (e: Exception) {
            logger.error(e.toString())
            logger.error("Publication reference in community not deleted")
        }

        publicationService.deleteById(pid)
    }
    }
}
