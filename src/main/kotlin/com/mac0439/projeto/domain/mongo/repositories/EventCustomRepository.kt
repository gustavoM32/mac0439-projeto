package com.mac0439.projeto.domain.mongo.repositories

import com.mac0439.projeto.domain.mongo.event.Event

interface EventCustomRepository {
    @Throws(Exception::class)
    fun updateEvent(event: Event)
}
