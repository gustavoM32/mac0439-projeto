package com.mac0439.projeto.controllers

import com.mac0439.projeto.domain.mongo.community.Community
import com.mac0439.projeto.domain.mongo.event.Status
import com.mac0439.projeto.services.CommunityService
import com.mac0439.projeto.services.PublicationService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class EventsController(
    private val communityService: CommunityService
) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)
    private val eventStatus: Map<Status, String> = mapOf(
        Status.PENDING to "pendente",
        Status.CANCELLED to "cancelado",
        Status.DONE to "realizado"
    )

    // Community events
    // Read all
    @GetMapping("/communities/{cid}/events")
    fun getEvents(@PathVariable cid: String, model: Model): String {
        logger.info("get /communities/$cid/events")
        val community: Community

        try {
            community = communityService.findById(cid)
        } catch (e: Exception) {
            logger.error(e.toString())
            return "redirect:/communities"
        }

        model.addAttribute("community", community)
        model.addAttribute("eventStatus", eventStatus)
        return "communities/events"
    }

    // Delete
    @DeleteMapping("/communities/{cid}/events/{eid}")
    @ResponseBody
    fun deleteEvent(@PathVariable cid: String, @PathVariable eid: String) {
        logger.info("delete /communities/${cid}/events/${eid}")
        try {
            communityService.deleteEvent(cid, eid)
        } catch (e:Exception) {
            logger.error(e.toString())
        }
    }
}
