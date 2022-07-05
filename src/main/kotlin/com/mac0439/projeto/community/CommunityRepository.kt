package com.mac0439.projeto.community

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CommunityRepository : MongoRepository<Community, String> {
    override fun findById(id: String): Optional<Community>
}
