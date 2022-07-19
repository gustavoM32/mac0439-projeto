package com.mac0439.projeto.controllers

import com.mac0439.projeto.domain.neo4j.repositories.UserRepository
import com.mac0439.projeto.domain.neo4j.task.Task
import com.mac0439.projeto.services.TaskService
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class TaskController(private val service: TaskService,
                     private val user_repository: UserRepository) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)
    @GetMapping("/tasks")
    fun getTasks(model: Model): String {
        model.addAttribute("tasks", service.findAll())
        return "tasks/index"
    }

    @GetMapping("tasks/{id}")
    fun getTasks(@PathVariable id: String, model: Model): String {
        model.addAttribute("hello", id)
        val task = service.findById(id)
        if (task.isEmpty) {
            return "error"
        }
        model.addAttribute("task", task.get())
        return "tasks/task"
    }

    @GetMapping("/tasks/add-task")
    fun addTask(@ModelAttribute new_task: Task): String {
        logger.info("get /tasks/add-task")

        return "tasks/add_task"
        //return repository.save(new_project)
    }

    @PostMapping("/tasks")
    fun postProjects(@ModelAttribute task: Task): String {
        logger.info("post /tasks")
        //project.creator
        val addedTask = service.addTask(task)
        return "redirect:/tasks/${addedTask.id}"
    }

}