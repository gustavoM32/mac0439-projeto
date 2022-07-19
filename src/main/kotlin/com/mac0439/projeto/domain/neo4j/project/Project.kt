package com.mac0439.projeto.domain.neo4j.project

import com.mac0439.projeto.domain.neo4j.user.User
import com.mac0439.projeto.domain.neo4j.task.Task
import com.mac0439.projeto.domain.neo4j.team.Team
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship
import org.springframework.data.neo4j.core.support.UUIDStringGenerator
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime

@Node("Project")
data class Project(

    //@Id @GeneratedValue val id: String? = null, // ok
    @Id
    @GeneratedValue(UUIDStringGenerator::class) val id: String? = null, // ok

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Field var created: LocalDateTime? = null, // ok
    @Field val name: String?, // ok
    @Field var description: String?= null,
    @Field val status: Boolean?= false, // true finishes false nfinished // ok

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Field var deadline: LocalDateTime?= null, // ok
    @Field var notes: Set<String>? = null, // ok

    @Relationship(type = "CREATED_BY") var creator: User? = null,
    @Relationship(type = "HAS_MEMBER") var member: Set<User>? = null,
    @Relationship(type = "HAS_SUBPROJECT") var subprojects: Set<Project>? = null,
    @Relationship(type = "HAS_TEAM") var team_members: Team? = null, // n muda
    @Relationship(type = "HAS_TASKS") var task_list: Set<Task>? = null

)
