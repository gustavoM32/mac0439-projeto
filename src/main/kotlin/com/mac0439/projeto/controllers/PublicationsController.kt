package com.mac0439.projeto.controllers

import com.mac0439.projeto.domain.mongo.community.Community
import com.mac0439.projeto.domain.mongo.publication.Publication
import com.mac0439.projeto.services.CommunityService
import com.mac0439.projeto.services.PublicationService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class PublicationsController(
    private val communityService: CommunityService,
    private val publicationService: PublicationService
) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    // Community publication
    // Create
    @GetMapping("/communities/{cid}/add-publication")
    fun getPublicationAdd(@PathVariable cid: String, model: Model, @ModelAttribute publication: Publication): String {
        logger.info("get /communities/${cid}/add-publication")
        val community: Community

        try {
            community = communityService.findById(cid)
        } catch (e: Exception) {
            logger.error(e.toString())
            return "redirect:/communities"
        }

        model.addAttribute("community", community)
        return "communities/add_publication"
    }

    @PostMapping("/communities/{cid}")
    fun postPublication(@PathVariable cid: String, @ModelAttribute publication: Publication): String {
        logger.info("post /communities/${cid}")
        publication.author = "gustavo_m32" // TODO: add the current logged in user
        communityService.addPublication(cid, publication)
        return "redirect:/communities/${cid}"
    }

    // Edit
    @GetMapping("/communities/{cid}/publications/{pid}/edit-publication")
    fun getPublicationEdit(@PathVariable cid: String, @PathVariable pid: String, model: Model): String {
        logger.info("get /communities/${cid}/publications/${pid}/edit-publication")
        val community: Community
        val publication: Publication

        try {
            community = communityService.findById(cid)
        } catch (e: Exception) {
            logger.error(e.toString())
            return "redirect:/communities"
        }

        try {
            publication = publicationService.findById(pid)
        } catch (e: Exception) {
            logger.error(e.toString())
            return "redirect:/communities/$cid"
        }

        model.addAttribute("community", community)
        model.addAttribute("publication", publication)
        return "communities/edit_publication"
    }

    @PostMapping("/communities/{cid}/publications/{pid}", params = ["update"])
    fun postPublicationUpdate(@PathVariable cid: String, @PathVariable pid: String, @ModelAttribute publication: Publication): String {
        logger.info("post /communities/$cid/publications/$pid update")

        try {
            publicationService.updatePublication(publication)
        } catch (e: Exception) {
            logger.error(e.toString())
            return "redirect:/communities"
        }

        return "redirect:/communities/$cid"
    }

    // Delete
    @DeleteMapping("/communities/{cid}/publications/{pid}")
    @ResponseBody
    fun deletePublication(@PathVariable cid: String, @PathVariable pid: String) {
        logger.info("delete /communities/${cid}/publications/${pid}")
        communityService.deletePublication(cid, pid)
    }
}
