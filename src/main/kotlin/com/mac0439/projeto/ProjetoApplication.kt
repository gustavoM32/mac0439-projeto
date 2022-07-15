package com.mac0439.projeto

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import com.mac0439.projeto.user.User
import com.mac0439.projeto.user.UserRepository
import org.springframework.boot.CommandLineRunner
import java.time.LocalDate

@SpringBootApplication
class ProjetoApplication() : CommandLineRunner {
	private val logger: Logger = LoggerFactory.getLogger(javaClass)
	private val userRepository: UserRepository

	override fun run(vararg args: String?) {
		logger.info("Iniciou")
		val user = User("admin", "admin", "123", "admin@admin.com", LocalDate.now(), "admin description")
		userRepository.save(user)
	}
}

fun main(args: Array<String>) {
	runApplication<ProjetoApplication>(*args)
}
