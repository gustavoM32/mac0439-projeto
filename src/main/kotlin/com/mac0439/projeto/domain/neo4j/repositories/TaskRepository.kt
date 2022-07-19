package com.mac0439.projeto.domain.neo4j.repositories

import com.mac0439.projeto.domain.neo4j.task.Task
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository : Neo4jRepository<Task, String>, TaskCustomRepository {

}