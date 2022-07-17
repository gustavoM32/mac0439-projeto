package com.mac0439.projeto.domain.neo4j.task

import com.mac0439.projeto.domain.neo4j.user.User
import com.mac0439.projeto.domain.neo4j.project.Project
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.time.LocalDateTime


@Node("Task")
data class Task(
    @Id val name: String? = null, // o spring muda pra mim
    private val description: String? = null,
    private val status: String? = null,
    private val notes: List<String>? = null,
    private val deadline: LocalDateTime? = null,
    private val team: Set<User>? = null,

    //@Relationship(type = "CREATED_BY", direction = Relationship.INCOMING) var creator: User,
    @Relationship(type = "SUBTASKS") var subtask: Set<Task>? = null,
    @Relationship(type = "HAS_TEAM") var team_members: Set<User>? = null // n muda

)