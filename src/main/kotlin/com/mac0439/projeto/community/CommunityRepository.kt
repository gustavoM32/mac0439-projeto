package com.mac0439.projeto.community

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CommunityRepository : MongoRepository<Community, String>
