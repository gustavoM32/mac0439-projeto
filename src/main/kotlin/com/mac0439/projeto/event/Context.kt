package com.mac0439.projeto.event

import org.springframework.data.mongodb.core.mapping.Field

data class Context(
    @Field val type: ContextType? = null,
    @Field val id: String? = null
)
