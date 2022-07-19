package com.mac0439.projeto

import org.slf4j.Logger
import org.slf4j.LoggerFactory
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
	private val userRepository: UserRepository,
	private val skillRepository: SkillRepository,
) : CommandLineRunner {
	private val logger: Logger = LoggerFactory.getLogger(javaClass)

	override fun run(vararg args: String?) {
		logger.info("Iniciou")
	}
}

fun main(args: Array<String>) {
	runApplication<ProjetoApplication>(*args)
}
