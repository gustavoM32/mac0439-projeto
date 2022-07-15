package com.mac0439.projeto.domain.mongo.publication

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

data class Comment(
    @Field val id: String? = null, // TODO: find a way to generate this id, as comments need to be identified
    @Field val author: String? = null,
    @Field val creationDate: LocalDateTime? = null,
    @Field val text: String? = null,
    @Field val likes: List<String>? = null
)
