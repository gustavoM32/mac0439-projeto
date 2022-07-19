package com.mac0439.projeto.services

import com.mac0439.projeto.domain.postgres.Skill
import com.mac0439.projeto.domain.postgres.repositories.SkillRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class SkillService(private val repository: SkillRepository) {
    fun findById(id: String): Optional<Skill> {
        return repository.findById(id)
    }

    fun findAll(): MutableIterable<Skill> {
        return repository.findAll()
    }
}