package com.mac0439.projeto.services

import com.mac0439.projeto.domain.mongo.community.Community
import com.mac0439.projeto.domain.mongo.publication.Publication
import com.mac0439.projeto.domain.mongo.repositories.CommunityRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CommunityService(private val repository: CommunityRepository) {
    fun findById(id: String): Optional<Community> {
        return repository.findById(id)
    }

    fun findAll(): List<Community> {
        return repository.findAll()
    }

    fun addCommunity(community: Community): Community {
        return repository.save(community)
    }

    fun deleteCommunity(id: String) {
        repository.deleteById(id)
    }

    fun addPublication(community: String, publication: Publication) {
        repository.addPublication(community, publication)
    }
}
