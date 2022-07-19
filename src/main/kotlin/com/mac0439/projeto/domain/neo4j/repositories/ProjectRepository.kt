package com.mac0439.projeto.domain.neo4j.repositories

import com.mac0439.projeto.domain.neo4j.project.Project
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.neo4j.repository.query.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProjectRepository : Neo4jRepository<Project, String> {

    fun findByName(@Param("name") name: String): Optional<Project>

    @Query("MATCH ((proj:Project {id:\$pid})-[:HAS_TASKS]->(task:Task {id: \$tid})) DETACH DELETE task")
    fun deleteTask(pid: String?, tid: String?): String?
//
//    MATCH (a:Person {name: $value1}),
//    (b:Person {name: $value2})
//    MERGE (a)-[r:LOVES]->(b)
    @Query("MATCH (proj:Project {id:\$parent_id}), MATCH (sp:Project {id:\$pid}) MERGE (proj)-[:HAS_SUBPROJECT]->(sp)")
    fun addProjectToParent(parent_id: String?, pid: String?): String?

}
