package com.mac0439.projeto.domain.mongo.event

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

@Document("events")
data class Event(
    @Id val id: String? = null,
    @Field val title: String? = null,
    @Field val description: String? = null,
    @Field val creator: String? = null, // event has one creator=user
    @Field val context: Context? = null, // event has one context=team/project/community
    @Field val status: Status? = null,
    @Field val date: LocalDateTime? = null,
    @Field val estimatedDuration: String? = null,
    @Field val notes: List<String>? = null,
    @Field val participants: List<Participant>? = null, // event has many participants=user
)
