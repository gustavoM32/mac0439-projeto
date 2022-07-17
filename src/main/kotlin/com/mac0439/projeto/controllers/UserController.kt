package com.mac0439.projeto.controllers

import com.mac0439.projeto.services.UserService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class UserController(private val service: UserService) {
    @GetMapping("/users")
    fun getUsers(model: Model): String {
        model.addAttribute("users", service.findAll())
        return "users/index"
    }

    @GetMapping("/users/{id}")
    fun getUser(@PathVariable id: String, model: Model): String {
        model.addAttribute("hello", id)
        val user = service.findById(id)
        if (user.isEmpty) {
            return "error"
        }
        user.addAttribute("user", user.get())
        return "users/user"
    }
}
