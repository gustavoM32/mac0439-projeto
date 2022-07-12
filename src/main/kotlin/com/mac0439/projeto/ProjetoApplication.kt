package com.mac0439.projeto

import com.mac0439.projeto.test.Person
import com.mac0439.projeto.test.PersonRepository
import org.slf4j.LoggerFactory
import org.slf4j.Logger
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import com.mac0439.projeto.domain.postgres.User
import com.mac0439.projeto.domain.postgres.repositories.UserRepository
import com.mac0439.projeto.domain.postgres.Skill
import com.mac0439.projeto.domain.postgres.repositories.SkillRepository
import java.time.LocalDate

@SpringBootApplication
class ProjetoApplication(
	private val personRepository: PersonRepository
	): CommandLineRunner {
	private val logger: Logger = LoggerFactory.getLogger(javaClass)

	override fun run(vararg args: String?) {
		logger.info("INICIOU")

		// Neo4J
		var greg = Person("Greg")
		var roy = Person("Roy")
		var craig = Person("Craig")

		personRepository.save(roy)
		personRepository.save(craig)
		greg.teammates = setOf(roy, craig)
		personRepository.save(greg)
	}
}

fun main(args: Array<String>) {
	runApplication<ProjetoApplication>(*args)
}
