package com.mac0439.projeto.controllers

import com.mac0439.projeto.services.CommunityService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class CommunityController(private val service: CommunityService) {
    @GetMapping("/communities")
    fun getCommunities(model: Model): String {
        model.addAttribute("communities", service.findAll())
        return "communities/index"
    }

    @GetMapping("/communities/{id}")
    fun getCommunity(@PathVariable id: String, model: Model): String {
        model.addAttribute("hello", id)
        val community = service.findById(id)
        if (community.isEmpty) {
            return "error"
        }
        model.addAttribute("community", community.get())
        return "communities/community"
    }
}