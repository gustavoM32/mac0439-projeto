package com.mac0439.projeto.domain.mongo.publication

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime

@Document("publications")
data class Publication(
    @Id val id: String? = null,
    @Field val title: String? = null,
    @Field val text: String? = null,
    @Field var author: String? = null, // publication has one author=user that may no longer exist
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Field var creationDate: LocalDateTime? = null,
    @Field val images: List<String>? = null, // TODO: manage images
    @Field val comments: List<Comment>? = null // publication has many comments
)
