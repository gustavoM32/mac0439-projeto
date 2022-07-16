package com.mac0439.projeto.controllers

import com.mac0439.projeto.domain.mongo.community.Community
import com.mac0439.projeto.services.CommunityService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import java.time.LocalDateTime

@Controller
class CommunityController(
    private val communityService: CommunityService
) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    // Communities

    // Read
    @GetMapping("/communities")
    fun getCommunities(model: Model): String {
        logger.info("get /communities")
        model.addAttribute("communities", communityService.findAll())
        return "communities/index"
    }

    // Create
    @GetMapping("/communities/add")
    fun getCommunitiesAdd(@ModelAttribute community: Community): String {
        logger.info("get /communities/add")

        return "communities/add"
    }

    @PostMapping("/communities/add")
    fun postCommunitiesAdd(@ModelAttribute community: Community): String {
        logger.info("post /communities/add")
        community.creator = "gustavo_m32" // TODO: add the current logged in user
        community.creationDate = LocalDateTime.now()
        communityService.addCommunity(community)

        return "redirect:/communities"
    }

    // Communities/{id}
    // Read
    @GetMapping("/communities/{id}")
    fun getCommunity(@PathVariable id: String, model: Model): String {
        logger.info("get /communities/${id}")
        val community = communityService.findById(id)
        if (community.isEmpty) {
            return "error" // TODO: temporary, change that
        }
        model.addAttribute("community", community.get())
        return "communities/community"
    }
}
