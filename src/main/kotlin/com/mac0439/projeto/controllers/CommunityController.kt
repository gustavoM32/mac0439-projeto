package com.mac0439.projeto.controllers

import com.mac0439.projeto.domain.mongo.community.Community
import com.mac0439.projeto.domain.mongo.publication.Comment
import com.mac0439.projeto.domain.mongo.publication.Publication
import com.mac0439.projeto.services.CommunityService
import com.mac0439.projeto.services.PublicationService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class CommunityController(
    private val communityService: CommunityService,
    private val publicationService: PublicationService
) { // TODO: Break this class down
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    // Communities
    // Read all
    @GetMapping("/communities")
    fun getCommunities(model: Model): String {
        logger.info("get /communities")
        model.addAttribute("communities", communityService.findAll())
        return "communities/index"
    }

    // Create
    @GetMapping("/communities/add-community")
    fun getCommunitiesAdd(@ModelAttribute community: Community): String {
        logger.info("get /communities/add-community")
        return "communities/add_community"
    }

    @PostMapping("/communities")
    fun postCommunities(@ModelAttribute community: Community): String {
        logger.info("post /communities")
        community.creator = "gustavo_m32" // TODO: add the current logged in user
        val addedCommunity = communityService.addCommunity(community)
        return "redirect:/communities/${addedCommunity.id}"
    }

    // Read one
    @GetMapping("/communities/{id}")
    fun getCommunity(@PathVariable id: String, model: Model): String {
        logger.info("get /communities/${id}")
        val community: Community

        try {
            community = communityService.findById(id)
        } catch (e: Exception) {
            logger.error(e.toString())
            return "redirect:/communities"
        }

        model.addAttribute("community", community)
        return "communities/community"
    }

    // Edit
    @GetMapping("/communities/{id}/edit-community")
    fun getCommunityEdit(@PathVariable id: String, model: Model): String {
        logger.info("get /communities/${id}/edit")
        val community: Community

        try {
            community = communityService.findById(id)
        } catch (e: Exception) {
            logger.error(e.toString())
            return "redirect:/communities"
        }

        model.addAttribute("community", community)
        return "communities/edit_community"
    }

    @PostMapping("/communities/{id}", params = ["update"])
    fun postCommunityUpdate(@PathVariable id: String, @ModelAttribute community: Community): String {
        logger.info("post /communities/${id} update")

        try {
            communityService.updateCommunity(community)
        } catch (e: Exception) {
            logger.error(e.toString())
            return "redirect:/communities"
        }

        return "redirect:/communities/$id"
    }

    // Delete
    @DeleteMapping("/communities/{cid}")
    @ResponseBody
    fun deleteCommunity(@PathVariable cid: String) {
        logger.info("delete /communities/${cid}")

        try {
            communityService.deleteCommunity(cid)
        } catch (e: Exception) {
            logger.error(e.toString())
            return
        }
    }

    // Publication
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
        publicationService.deletePublication(pid)
    }

    // Comment
    // Create
    @GetMapping("/communities/{cid}/publications/{pid}/add-comment")
    fun getCommentAdd(@PathVariable cid: String, @PathVariable pid: String, model: Model, @ModelAttribute comment: Comment): String {
        logger.info("get /communities/${cid}/publications/${pid}/add-comment")
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
            return "redirect:/communities/${cid}"
        }

        model.addAttribute("community", community)
        model.addAttribute("publication", publication)

        return "communities/add_comment"
    }

    @PostMapping("/communities/{cid}/publications/{pid}")
    fun postComment(@PathVariable cid: String, @PathVariable pid: String, @ModelAttribute comment: Comment): String {
        logger.info("post /communities/${cid}/publications/${pid}")

        comment.author = "gustavo_m32" // TODO: add the current logged in user
        publicationService.addComment(pid, comment)

        return "redirect:/communities/${cid}"
    }

    // Delete
    @DeleteMapping("/communities/{cid}/publications/{pid}/comments/{cmid}")
    @ResponseBody
    fun deleteComment(@PathVariable cid: String, @PathVariable pid: String, @PathVariable cmid: String) {
        logger.info("delete /communities/${cid}/publications/${pid}/comments/${cmid}")
        try {
            publicationService.deleteComment(pid, cmid)
        } catch (e:Exception) {
            logger.error(e.toString())
        }
    }
}
