package com.mac0439.projeto.community

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
}
