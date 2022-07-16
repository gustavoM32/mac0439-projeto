package com.mac0439.projeto.domain.mongo.repositories

import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.stereotype.Repository

@Repository
class CommunityCustomRepositoryImpl(private val mongoOperations: MongoOperations) : CommunityCustomRepository {
}
