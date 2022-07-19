package com.mac0439.projeto.domain.neo4j.repositories

import com.mac0439.projeto.domain.neo4j.project.Project
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProjectRepository : Neo4jRepository<Project, String> {

    fun findByName(@Param("name") name: String): Optional<Project>
}

//interface MovieRepository : Neo4jRepository<Movie?, Long?> {
//    fun findByTitle(@Param("title") title: String?): Movie?
//    fun findByTitleLike(@Param("title") title: String?): Collection<Movie?>?
//
//    @Query("MATCH (m:Movie)<-[r:ACTED_IN]-(a:Person) RETURN m,r,a LIMIT {limit}")
//    fun graph(@Param("limit") limit: Int): Collection<Movie?>?
//}