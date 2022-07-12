package com.mac0439.projeto.event

import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

data class Viewer(
    @Field val id: String? = null,
    @Field val confirmationDate: LocalDateTime? = null
)
