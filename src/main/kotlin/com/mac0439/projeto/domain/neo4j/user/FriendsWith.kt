package com.mac0439.projeto.domain.neo4j.user

import org.springframework.data.neo4j.core.schema.*

@RelationshipProperties
class FriendsWith(
    @RelationshipId
    var id: Long? = null,
    @TargetNode
    var user: User
)