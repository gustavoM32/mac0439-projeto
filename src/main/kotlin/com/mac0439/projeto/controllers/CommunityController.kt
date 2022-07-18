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
import kotlin.math.min

@Controller
class CommunityController(
    private val communityService: CommunityService,
    private val publicationService: PublicationService
) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @ModelAttribute("recentCommentComparator")
    fun recentCommentComparator() = compareByDescending<Comment> { it.creationDate }

    @ModelAttribute("recentPublicationComparator")
    fun recentPublicationComparator() = compareByDescending<Publication> { it.creationDate }

    fun <E> getFirstN(list: List<E>?, n: Int): List<E> {
        if (list == null) return listOf()
        return list.slice(0 until min(n, list.size))
    }

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

        model.addAttribute("newComment", Comment())
        model.addAttribute("events", getFirstN(community.events?.sortedByDescending { it.date }, 5))
        model.addAttribute("members", getFirstN(community.members, 5))
        model.addAttribute("projects", getFirstN(community.projects, 5))

        model.addAttribute("currentUser", "gustavo_m32") // TODO: get current user
        model.addAttribute("community", community)
        model.addAttribute("nl", "\n")
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

    // Projects
    // Read all
    @GetMapping("/communities/{cid}/projects")
    fun getProjects(@PathVariable cid: String, model: Model): String {
        logger.info("get /communities/$cid/projects")
        val community: Community

        try {
            community = communityService.findById(cid)
        } catch (e: Exception) {
            logger.error(e.toString())
            return "redirect:/communities"
        }

        model.addAttribute("community", community)
        return "communities/projects"
    }

    // Members
    // Read all
    @GetMapping("/communities/{cid}/members")
    fun getMembers(@PathVariable cid: String, model: Model): String {
        logger.info("get /communities/$cid/members")
        val community: Community

        try {
            community = communityService.findById(cid)
        } catch (e: Exception) {
            logger.error(e.toString())
            return "redirect:/communities"
        }

        model.addAttribute("community", community)
        return "communities/members"
    }
}
