package com.mac0439.projeto.domain.mongo.publication

import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import java.util.*

data class Comment(
    @Id val id: String? = UUID.randomUUID().toString(),
    @Field var author: String? = null, // comment has one author=user that may no longer exist
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Field var creationDate: LocalDateTime? = null,
    @Field val text: String? = null,
    @Field val likes: Set<String>? = null
)
