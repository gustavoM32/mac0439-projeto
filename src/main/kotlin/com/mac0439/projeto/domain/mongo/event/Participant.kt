package com.mac0439.projeto.domain.mongo.event

import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

data class Participant(
    @Field val id: String? = null,
    @Field val confirmationDate: LocalDateTime? = null
)
