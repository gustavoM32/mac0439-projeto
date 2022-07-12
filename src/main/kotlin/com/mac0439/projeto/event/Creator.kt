package com.mac0439.projeto.event

import org.springframework.data.mongodb.core.mapping.Field

data class Creator(
    @Field val type: CreatorType? = null,
    @Field val id: String? = null
)
