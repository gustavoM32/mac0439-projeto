package com.mac0439.projeto.community

import com.mac0439.projeto.event.Event
import com.mac0439.projeto.publication.Publication
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.DocumentReference
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

@Document("communities")
data class Community(
    @Id val id: String? = null,
    @Field val name: String? = null,
    @Field val description: String? = null,
    @Field val creator: String? = null, // community has one creator=user
    @Field val creationDate: LocalDateTime? = null,
    @Field val projects: List<Project>? = null, // community has many projects
    @Field val members: List<Member>? = null, // community has many members

    @DocumentReference(lazy=true)
    @Field val events: List<Event>? = null, // community has many events

    @DocumentReference(lazy=true)
    @Field val publications: List<Publication>? = null // community has many publications
)
