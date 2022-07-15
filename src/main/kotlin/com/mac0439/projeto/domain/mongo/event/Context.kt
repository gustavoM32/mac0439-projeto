package com.mac0439.projeto.domain.mongo.event

import org.springframework.data.mongodb.core.mapping.Field

data class Context(
    @Field val type: ContextType? = null,
    @Field val id: String? = null
)
