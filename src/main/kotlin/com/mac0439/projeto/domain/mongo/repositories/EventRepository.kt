package com.mac0439.projeto.domain.mongo.repositories

import com.mac0439.projeto.domain.mongo.event.Event
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface EventRepository : MongoRepository<Event, String>, EventCustomRepository
