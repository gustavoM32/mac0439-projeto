package com.mac0439.projeto.services

import com.mac0439.projeto.domain.neo4j.project.Project
import com.mac0439.projeto.domain.neo4j.repositories.ProjectRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProjectService(private val repository: ProjectRepository) {
    fun findById(id: String): Optional<Project> {
        return repository.findById(id)
    }

    fun findAll(): List<Project> {
        return repository.findAll()
    }
}