package com.mac0439.projeto.domain.mongo.repositories

import com.mac0439.projeto.domain.mongo.community.Community
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CommunityRepository : MongoRepository<Community, String>, CommunityCustomRepository
