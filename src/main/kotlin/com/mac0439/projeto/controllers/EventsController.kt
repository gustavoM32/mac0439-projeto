package com.mac0439.projeto.controllers

import com.mac0439.projeto.domain.mongo.community.Community
import com.mac0439.projeto.domain.mongo.event.Event
import com.mac0439.projeto.domain.mongo.event.Status
import com.mac0439.projeto.services.CommunityService
import com.mac0439.projeto.services.EventService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class EventsController(
    private val communityService: CommunityService,
    private val eventService: EventService
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

        model.addAttribute("events", community.events?.sortedByDescending { it.date } ?: listOf<Event>())
        model.addAttribute("community", community)
        model.addAttribute("eventStatus", eventStatus)
        return "communities/events/index"
    }

    // Create
    @GetMapping("/communities/{cid}/events/add-event")
    fun getEventAdd(@PathVariable cid: String, model: Model, @ModelAttribute event: Event): String {
        logger.info("get /communities/${cid}/events/add-event")
        val community: Community

        try {
            community = communityService.findById(cid)
        } catch (e: Exception) {
            logger.error(e.toString())
            return "redirect:/communities/$cid/events"
        }

        model.addAttribute("community", community)
        return "communities/events/add_event"
    }

    @PostMapping("/communities/{cid}/events")
    fun postEventPublication(@PathVariable cid: String, @ModelAttribute event: Event): String {
        logger.info("post /communities/${cid}/events")
        event.creator = "gustavo_m32" // TODO: add the current logged in user
        communityService.addEvent(cid, event)

        return "redirect:/communities/${cid}/events"
    }

    // Edit
    @GetMapping("/communities/{cid}/events/{eid}/edit-event")
    fun getEventEdit(@PathVariable cid: String, @PathVariable eid: String, model: Model): String {
        logger.info("get /communities/${cid}/events/${eid}/edit-event")
        val community: Community
        val event: Event

        try {
            community = communityService.findById(cid)
        } catch (e: Exception) {
            logger.error(e.toString())
            return "redirect:/communities"
        }

        try {
            event = eventService.findById(eid)
        } catch (e: Exception) {
            logger.error(e.toString())
            return "redirect:/communities/$cid"
        }

        model.addAttribute("community", community)
        model.addAttribute("event", event)
        return "communities/events/edit_event"
    }

    @PostMapping("/communities/{cid}/events/{eid}", params = ["update"])
    fun postEventUpdate(@PathVariable cid: String, @PathVariable eid: String, @ModelAttribute event: Event): String {
        logger.info("post /communities/$cid/events/$eid update")

        try {
            println(event)
            eventService.updateEvent(event)
        } catch (e: Exception) {
            logger.error(e.toString())
            return "redirect:/communities"
        }

        return "redirect:/communities/$cid/events"
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
