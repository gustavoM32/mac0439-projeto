package com.mac0439.projeto

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import com.mac0439.projeto.user.User
import com.mac0439.projeto.user.UserRepository
import com.mac0439.projeto.user.Skill
import com.mac0439.projeto.user.SkillRepository
import com.mac0439.projeto.user.HasSkill
import com.mac0439.projeto.user.HasSkillRepository
import org.springframework.boot.CommandLineRunner
import java.time.LocalDate

@SpringBootApplication
class ProjetoApplication(
	private val userRepository: UserRepository,
	private val skillRepository: SkillRepository,
	private val hasSkillRepository: HasSkillRepository
) : CommandLineRunner {
	private val logger: Logger = LoggerFactory.getLogger(javaClass)

	override fun run(vararg args: String?) {
		userRepository.deleteAll()
		skillRepository.deleteAll()
		hasSkillRepository.deleteAll()

		logger.info("Iniciou")
		var user = User("admin", "admin", "123", "admin@admin.com", LocalDate.now(), "admin description")
		userRepository.save(user)
		user = User("user2", "user2", "123", "user@admin.com", LocalDate.now(), "user description")
		userRepository.save(user)

		var skill = Skill("Java", "Good at Java")
		skillRepository.save(skill)
		skill = Skill("C++", "Good at C++")
		skillRepository.save(skill)

		var hasSkill = HasSkill("admin", 1)
		hasSkillRepository.save(hasSkill)
		hasSkill = HasSkill("user2", 1)
		hasSkillRepository.save(hasSkill)
		hasSkill = HasSkill("user2", 2)
		hasSkillRepository.save(hasSkill)
	}
}

fun main(args: Array<String>) {
	runApplication<ProjetoApplication>(*args)
}
