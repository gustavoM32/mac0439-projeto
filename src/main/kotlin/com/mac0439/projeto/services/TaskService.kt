package com.mac0439.projeto.services

import com.mac0439.projeto.domain.neo4j.project.Project
import com.mac0439.projeto.domain.neo4j.repositories.TaskRepository
import com.mac0439.projeto.domain.neo4j.task.Task
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Service
class TaskService(private val repository: TaskRepository) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    fun findById(id: String): Optional<Task> {
        return repository.findById(id)
    }
    fun addTask(task: Task): Task {
        return repository.save(task)
    }

    fun deleteById(id: String) {
        repository.deleteById(id)
    }

    fun findAll(): List<Task> {
        return repository.findAll()
    }

    @Throws(Exception::class)
    fun deleteTask(id: String) {
        val task: Task

        try {
            task = this.findById(id).get()
        } catch (e: Exception) {
            logger.error(e.toString())
            throw Exception("Project to delete not found")
        }

        logger.info("found!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1")

        // project deletion should delete its subprojects
        task.subtasks?.let {
            for (s: Task in it) {
                checkNotNull(s.id)
                repository.deleteById(s.id)
            }
        }

        repository.deleteById(id)
    }
}