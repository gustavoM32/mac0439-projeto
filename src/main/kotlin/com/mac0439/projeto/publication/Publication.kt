package com.mac0439.projeto.publication

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

@Document("publications")
data class Publication(
    @Id val id: String? = null,
    @Field val title: String? = null,
    @Field val text: String? = null,
    @Field val author: String? = null, // publication has one author=user
    @Field val creationDate: LocalDateTime? = null,
    @Field val images: List<String>? = null, // TODO: manage images
    @Field val comments: List<Comment>? = null // publication has many comments
)
