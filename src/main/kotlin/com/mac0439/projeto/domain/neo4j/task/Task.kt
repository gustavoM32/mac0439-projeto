package com.mac0439.projeto.domain.neo4j.task

import com.mac0439.projeto.domain.neo4j.user.User
import com.mac0439.projeto.domain.neo4j.project.Project
import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship
import org.springframework.data.neo4j.core.support.UUIDStringGenerator
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.time.LocalDateTime


@Node("Task")
data class Task(
    @Id
    @GeneratedValue(UUIDStringGenerator::class) val id: String? = null, // ok
    var name: String? = null, // o spring muda pra mim // ok
    var description: String? = null, // ok
    var status: Boolean? = false,  // ok
    var notes: List<String>? = null, // ok
    var deadline: LocalDateTime? = null, // ok
    var team: Set<User>? = null,

    //@Relationship(type = "CREATED_BY", direction = Relationship.INCOMING) var creator: User,
    @Relationship(type = "SUBTASKS") var subtasks: Set<Task>? = null, // ok
    @Relationship(type = "HAS_TEAM") var team_members: Set<User>? = null // n muda // ok

)