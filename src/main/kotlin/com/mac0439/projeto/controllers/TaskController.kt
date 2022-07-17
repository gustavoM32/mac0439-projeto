package com.mac0439.projeto.controllers

import com.mac0439.projeto.services.TaskService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class TaskController(private val service: TaskService) {
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
}