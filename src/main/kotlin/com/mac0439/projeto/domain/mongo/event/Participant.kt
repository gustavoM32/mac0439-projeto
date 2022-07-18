package com.mac0439.projeto.domain.mongo.event

import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime

data class Participant(
    @Field val id: String? = null,
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Field val confirmationDate: LocalDateTime? = null
)
