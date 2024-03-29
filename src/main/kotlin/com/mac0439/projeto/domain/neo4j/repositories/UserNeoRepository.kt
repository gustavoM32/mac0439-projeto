package com.mac0439.projeto.domain.neo4j.repositories

import com.mac0439.projeto.domain.neo4j.user.User
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserNeoRepository: Neo4jRepository<User, String> {
    fun findByName(@Param("name") name: String): Optional<User>
}