package com.mac0439.projeto.domain.neo4j.task

import com.mac0439.projeto.domain.neo4j.user.User
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship
import java.time.LocalDateTime


@Node("Task")
data class Task(
    @Id val name: String, // o spring muda pra mim
    private val description: String?,
    private val status: String,
    private val notes: List<String>? = null,
    private val deadline: LocalDateTime,
    private val team: Set<User>,

    //@Relationship(type = "CREATED_BY", direction = Relationship.INCOMING) var creator: User,
    @Relationship(type = "SUBTASKS") var subtask: Set<Task>,
    @Relationship(type = "HAS_TEAM") var team_members: Set<User> // n muda

)