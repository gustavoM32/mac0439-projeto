package com.mac0439.projeto.domain.neo4j.team

import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship

@Node("Team")
data class Team(
    @Id val name: String? = null, // o spring muda pra mim

)
