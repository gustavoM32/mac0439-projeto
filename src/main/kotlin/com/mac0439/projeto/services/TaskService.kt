package com.mac0439.projeto.services

import com.mac0439.projeto.domain.neo4j.repositories.TaskRepository
import com.mac0439.projeto.domain.neo4j.task.Task
import org.springframework.stereotype.Service
import java.util.*

@Service
class TaskService(private val repository: TaskRepository) {
    fun findById(id: String): Optional<Task> {
        return repository.findById(id)
    }
    fun addTask(task: Task): Task {
        return repository.save(task)
    }

    fun findAll(): List<Task> {
        return repository.findAll()
    }
}