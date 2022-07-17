package com.mac0439.projeto.domain.mongo.community

import com.mac0439.projeto.domain.mongo.event.Event
import com.mac0439.projeto.domain.mongo.publication.Publication
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
    @Field var creator: String? = null, // community has one creator=user that may no longer exist
    @Field var creationDate: LocalDateTime? = null,
    // TODO: project deletion should delete it from this list (Neo4J)
    @Field val projects: List<Project>? = null, // community has many projects that depend on it
    // TODO: user deletion should delete it from this list (Postgres)
    @Field val members: List<Member>? = null, // community has many members that should exist

    @DocumentReference(lazy=true)
    @Field val events: List<Event>? = null, // community has many events that depend on it

    @DocumentReference(lazy=true)
    @Field val publications: List<Publication>? = null // community has many publications that depend on it
)
