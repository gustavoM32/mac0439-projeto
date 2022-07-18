package com.mac0439.projeto.domain.mongo.event

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime

@Document("events")
data class Event(
    @Id val id: String? = null,
    @Field val title: String? = null,
    @Field val description: String? = null,
    @Field val creator: String? = null, // event has one creator=user that may no longer exist
//    TODO: Check if this context field is necessary
//    @Field val context: Context? = null, // event has one context=team/project/community that should exist
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Field val date: LocalDateTime? = null,
    @Field val estimatedDuration: String? = null,
    @Field val notes: List<String>? = null,
    // TODO: user deletion should delete it from this list (Postgres)
    @Field val participants: List<Participant>? = null, // event has many participants=user that should exist
)
