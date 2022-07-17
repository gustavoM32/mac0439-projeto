package com.mac0439.projeto

import com.mac0439.projeto.domain.neo4j.project.Project
import com.mac0439.projeto.domain.neo4j.repositories.ProjectRepository
import com.mac0439.projeto.domain.neo4j.repositories.TaskRepository
import com.mac0439.projeto.domain.neo4j.task.Task
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
class ProjetoApplication(private val projectRepository: ProjectRepository, private val taskRepository: TaskRepository): CommandLineRunner {
	private val logger: Logger = LoggerFactory.getLogger(javaClass)

	override fun run(vararg args: String?) {
		logger.info("INICIOU")

		// Neo4J -- Project
		var coolParty = Project("Stu Surprise Party")
		var makeCake = Project("Make Birthday Cake")
		var singForHim = Project("Arrange singers for Stus Bday")

		//projectRepository.save(makeCake)
		//projectRepository.save(singForHim)
		coolParty.subproject = setOf(makeCake, singForHim)
		projectRepository.save(coolParty)

		// NEO4J -- Task
		var bakeCake = Task("Bake a cake for Stu")
		var buy4Cake = Task("Buy stuff for cake")
		var hireSinger = Task("Call Singers")

		// TASK & PROJECT
		makeCake.task_list = setOf(bakeCake, buy4Cake)
		singForHim.task_list = setOf(hireSinger)

		projectRepository.save(makeCake)
		projectRepository.save(singForHim)

		taskRepository.save(bakeCake)
		taskRepository.save(buy4Cake)
		taskRepository.save(hireSinger)
	}
}



fun main(args: Array<String>) {
	runApplication<ProjetoApplication>(*args)
}
