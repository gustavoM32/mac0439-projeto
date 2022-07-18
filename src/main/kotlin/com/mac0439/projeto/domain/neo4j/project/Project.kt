package com.mac0439.projeto.domain.neo4j.project

import com.mac0439.projeto.domain.neo4j.user.User
import com.mac0439.projeto.domain.neo4j.task.Task
import com.mac0439.projeto.domain.neo4j.team.Team
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime

@Node("Project")
data class Project(

    @Id val id: String? = null, // ok

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") public val created: LocalDateTime? = null, // ok
    val name: String?, // ok
    var description: String?= null,
    val status: Boolean?= false, // true finishes false nfinished // ok

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") var deadline: LocalDateTime?= null, // ok
    var notes: Set<String>? = null, // ok

    @Relationship(type = "CREATED_BY") var creator: User? = null,
    @Relationship(type = "HAS_MEMBER") var member: Set<User>? = null,
    @Relationship(type = "HAS_SUBPROJECT") var subprojects: Set<Project>? = null,
    @Relationship(type = "HAS_TEAM") var team_members: Team? = null, // n muda
    @Relationship(type = "HAS_TASKS") var task_list: Set<Task>? = null

)
