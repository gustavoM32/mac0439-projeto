package com.mac0439.projeto.community

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class CommunityController(private val service: CommunityService) {
    @GetMapping("/community/{id}")
    fun getCommunity(@PathVariable id: String, model: Model): String? {
        model.addAttribute("hello", id)
        var community = service.findById(id)
        if (community.isEmpty) {
            return "error"
        }
        model.addAttribute("community", community.get())
        return "community"
    }
}
