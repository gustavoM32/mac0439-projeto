package com.mac0439.projeto.domain.mongo.community

import org.springframework.data.mongodb.core.mapping.Field

data class Project(
    @Field val id: String? = null,
    @Field val name: String? = null
)
