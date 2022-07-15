package com.mac0439.projeto.domain.mongo.community

import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

data class Member(
    @Field val id: String? = null,
    @Field val entryDate: LocalDateTime? = null
)
