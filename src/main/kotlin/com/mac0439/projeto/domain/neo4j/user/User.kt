package com.mac0439.projeto.domain.neo4j.user
import com.mac0439.projeto.domain.neo4j.project.Project
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship
import java.time.LocalDateTime

@Node("User")
data class User(
    @Id val name: String, // o spring muda pra mim

    @Relationship(type = "MEMBER_OF") var project: Project,
    @Relationship(type = "FRIENDS_WITH") var friends: Set<User>
)
