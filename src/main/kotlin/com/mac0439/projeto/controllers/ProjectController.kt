package com.mac0439.projeto.controllers

import com.mac0439.projeto.services.ProjectService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class ProjectController(private val service: ProjectService) {
    @GetMapping("/projects")
    fun getProjects(model: Model): String {
        model.addAttribute("projects", service.findAll())
        return "projects/index"
    }

    @GetMapping("/projects/{id}")
    fun getProject(@PathVariable id: String, model: Model): String {
        model.addAttribute("hello", id)
        val project = service.findById(id)
        if (project.isEmpty) {
            return "error"
        }
        model.addAttribute("project", project.get())
        return "projects/project"
    }
}