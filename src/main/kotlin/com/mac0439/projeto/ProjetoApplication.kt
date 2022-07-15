package com.mac0439.projeto

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProjetoApplication() : CommandLineRunner {
	private val logger: Logger = LoggerFactory.getLogger(javaClass)

	override fun run(vararg args: String?) {
		logger.info("Iniciou")
	}
}

fun main(args: Array<String>) {
	runApplication<ProjetoApplication>(*args)
}
