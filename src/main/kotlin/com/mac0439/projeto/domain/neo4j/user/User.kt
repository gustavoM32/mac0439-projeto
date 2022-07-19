package com.mac0439.projeto.domain.neo4j.user
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship

@Node("User")
data class User(
    @Id var name: String? = null, // o spring muda pra mim

    @Relationship(type = "MEMBER_OF") var projects: Set<MemberOf>? = null,
    @Relationship(type = "FRIENDS_WITH") var friends: Set<FriendsWith>? = null
)
