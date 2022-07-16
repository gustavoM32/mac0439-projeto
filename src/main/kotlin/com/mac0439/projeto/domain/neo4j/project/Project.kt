package com.mac0439.projeto.domain.neo4j.project

import com.mac0439.projeto.domain.neo4j.user.User
import com.mac0439.projeto.domain.neo4j.task.Task
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship
import java.time.LocalDateTime

@Node("Project")
data class Project(
    @Id val name: String? = null, // o spring muda pra mim
//    private val description: String?= null,
//    private val status: String?= null,
//    private val deadline: LocalDateTime?= null,
//    private val created: LocalDateTime?= null,
//    private val notes: String? = null,

//    @Relationship(type = "CREATED_BY") var creator: User,
    @Relationship(type = "SUBPROJECT") var subproject: Set<Project>? = null,
//    @Relationship(type = "HAS_TEAM") var team_members: Set<User>, // n muda
//    @Relationship(type = "HAS_TASK") var task_list: Set<Task>

)
