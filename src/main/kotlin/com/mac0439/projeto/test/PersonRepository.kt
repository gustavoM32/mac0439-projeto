package com.mac0439.projeto.test

import org.springframework.data.neo4j.repository.Neo4jRepository

interface PersonRepository : Neo4jRepository<Person, String>
