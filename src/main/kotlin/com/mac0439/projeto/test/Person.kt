package com.mac0439.projeto.test

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship
import java.util.*

@Node("Person")
data class Person(
    @Id val name: String? = null,
    @Relationship(type = "TEAMMATE") var teammates: Set<Person>? = null
)
