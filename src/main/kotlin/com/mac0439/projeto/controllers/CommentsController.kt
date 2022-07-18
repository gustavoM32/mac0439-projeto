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
import javax.servlet.http.HttpServletRequest

@Controller
class CommentsController(
    private val communityService: CommunityService,
    private val publicationService: PublicationService
) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    // Community publication comment
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

        return "redirect:/communities/$cid"
    }

    // Edit
    @GetMapping("/communities/{cid}/publications/{pid}/comments/{cmid}/edit")
    fun getCommentEdit(@PathVariable cid: String, @PathVariable pid: String, @PathVariable cmid: String, model: Model): String {
        logger.info("get /communities/$cid/publications/{pid}/comments/$cmid/edit")
        val community: Community
        val publication: Publication
        val comment: Comment

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

        try {
            comment = publicationService.findCommentById(pid, cmid)
        } catch (e: Exception) {
            logger.error(e.toString())
            return "redirect:/communities/$cid"
        }

        model.addAttribute("community", community)
        model.addAttribute("publication", publication)
        model.addAttribute("comment", comment)
        return "communities/comments/edit"
    }

    @PostMapping("/communities/{cid}/publications/{pid}/comments/{cmid}", params = ["update"])
    fun postCommentUpdate(@PathVariable cid: String, @PathVariable pid: String, @PathVariable cmid: String, @ModelAttribute comment: Comment): String {
        logger.info("post /communities/$cid/publications/$pid/comments/$cmid update")

        try {
            publicationService.updateComment(pid, comment)
        } catch (e: Exception) {
            logger.error(e.toString())
            return "redirect:/communities"
        }

        return "redirect:/communities/$cid"
    }

    @PostMapping("/communities/{cid}/publications/{pid}/comments/{cmid}", params = ["like"])
    fun postCommentLike(@PathVariable cid: String, @PathVariable pid: String, @PathVariable cmid: String, req: HttpServletRequest): String {
        val like = req.getParameter("like")
        logger.info("post /communities/$cid/publications/$pid/comments/$cmid like=$like")
        val currentUser = "gustavo_m32" // TODO: get the actual user

        try {
            if (like == "add") {
                publicationService.addLikeToComment(pid, cmid, currentUser)
            } else {
                publicationService.removeLikeFromComment(pid, cmid, currentUser)
            }
        } catch (e: Exception) {
            logger.error(e.toString())
            return "redirect:/communities"
        }

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
