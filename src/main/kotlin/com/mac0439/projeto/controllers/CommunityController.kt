package com.mac0439.projeto.controllers

import com.mac0439.projeto.domain.mongo.community.Community
import com.mac0439.projeto.domain.mongo.publication.Publication
import com.mac0439.projeto.services.CommunityService
import com.mac0439.projeto.services.PublicationService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import java.time.LocalDateTime
import javax.servlet.http.HttpServletRequest

@Controller
class CommunityController(
    private val communityService: CommunityService,
    private val publicationService: PublicationService
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

    // Delete
    @PostMapping("/communities", params = ["cid", "remove"]) // TODO: indirect way to delete
    fun deleteCommunities(req: HttpServletRequest): String {
        val cid: String = req.getParameter("cid")
        logger.info("delete /communities (cid=${cid} remove)")
        val community = communityService.findById(cid)
        if (community.isEmpty) {
            return "error" // TODO: temporary, change that
        }

        for (p: Publication in community.get().publications!!) {
            publicationService.deleteById(p.id!!) // TODO: maybe this should be in communityService
        }

        communityService.deleteCommunity(cid)
        return "redirect:/communities"
    }

    // Publication
    // Create
    @GetMapping("/communities/{cid}/add-publication")
    fun getPublicationAdd(@PathVariable cid: String, model: Model, @ModelAttribute publication: Publication): String {
        logger.info("get /communities/${cid}/add-publication")

        val community = communityService.findById(cid)
        if (community.isEmpty) {
            return "error" // TODO: temporary, change that
        }
        model.addAttribute("community", community.get())

        return "communities/add_publication"
    }

    @PostMapping("/communities/{cid}/add-publication")
    fun postPublicationAdd(@PathVariable cid: String, @ModelAttribute publication: Publication): String {
        logger.info("post /communities/${cid}/add-publication")

        publication.author = "gustavo_m32" // TODO: add the current logged in user
        publication.creationDate = LocalDateTime.now()
        val publication = publicationService.addPublication(publication)
        communityService.addPublication(cid, publication)

        return "redirect:/communities/{cid}"
    }
}
