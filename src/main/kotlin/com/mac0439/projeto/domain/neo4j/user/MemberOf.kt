package com.mac0439.projeto.domain.neo4j.user

import com.mac0439.projeto.domain.neo4j.project.Project
import org.springframework.data.neo4j.core.schema.*

@RelationshipProperties
class MemberOf(
    @RelationshipId
    var id: Long? = null,
    @TargetNode
    var project: Project? = null
)