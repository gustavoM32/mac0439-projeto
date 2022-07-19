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
		userRepository.deleteAll()
		skillRepository.deleteAll()

		logger.info("Iniciou")
		var user = User("admin", "admin", "123", "admin@admin.com", LocalDate.now(), "admin description")

		var skill = Skill("Java", "Good at Java")
		skillRepository.save(skill)
		user.add_skill(skill)

		skill = Skill("Kotlin", "Good at Kotlin")
		skillRepository.save(skill)
		user.add_skill(skill)
		userRepository.save(user)

		user = User("user2", "user2", "123", "user@admin.com", LocalDate.now(), "user description")
		skill = Skill("C++", "Good at C++")
		skillRepository.save(skill)
		user.add_skill(skill)
		userRepository.save(user)
	}
}

fun main(args: Array<String>) {
	runApplication<ProjetoApplication>(*args)
}
