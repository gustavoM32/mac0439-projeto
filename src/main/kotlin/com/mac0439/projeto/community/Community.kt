package com.mac0439.projeto.community

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.DocumentReference
import org.springframework.data.mongodb.core.mapping.Field
import java.util.Date

data class Project(
    @Field(name = "id")
    val id: String,
    @Field(name = "name")
    val name: String?)

data class Member(
    @Field(name = "id")
    val id: String,
    @Field(name = "entry_date")
    val entryDate: Date?)

@Document("communities")
data class Community(
    @Id
    val id: String,

    @Field(name = "name")
    val name: String? = null,

    @Field(name = "description")
    val description: String? = null,

    @Field(name = "creation_date")
    val creationDate: Date? = null,

    // @DocumentReference(lazy=true)
    @Field(name = "events") // community has many events
    val events: List<String> = emptyList(), // TODO: Event

    // @DocumentReference(lazy=true)
    @Field(name = "publications") // community has many publications
    val publications: List<String> = emptyList(), // TODO: Publications

    @Field(name = "creator")
    val creator: String? = null,

    @Field(name = "projects") // community has many projects
    var projects: List<Project> = emptyList(),

    @Field(name = "members") // community has many members
    val members: List<Member> = emptyList()
)
