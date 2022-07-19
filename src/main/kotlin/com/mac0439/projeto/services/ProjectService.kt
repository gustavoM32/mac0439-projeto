package com.mac0439.projeto.services

import com.mac0439.projeto.domain.neo4j.project.Project
import com.mac0439.projeto.domain.neo4j.repositories.ProjectRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class ProjectService(private val repository: ProjectRepository) {
//    fun findById(id: String): Optional<Project> {
//        return repository.findById(id)
//    }
     fun findById(id: String): Optional<Project> {
        return repository.findById(id)
    }

    fun addProject(project: Project): Project {
        project.created = LocalDateTime.now()
        return repository.save(project)
    }

    fun findByName(name: String): Optional<Project> {
        return repository.findByName(name)
    }
    fun findAll(): List<Project> {
        return repository.findAll()
    }
}
