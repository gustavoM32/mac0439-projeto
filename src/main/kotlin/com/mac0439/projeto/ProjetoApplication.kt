package com.mac0439.projeto

import com.mac0439.projeto.domain.neo4j.project.Project
import com.mac0439.projeto.domain.neo4j.repositories.ProjectRepository
import com.mac0439.projeto.domain.neo4j.repositories.TaskRepository
import com.mac0439.projeto.domain.neo4j.repositories.UserRepository
import com.mac0439.projeto.domain.neo4j.task.Task
import com.mac0439.projeto.domain.neo4j.user.User
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDateTime

@SpringBootApplication
class ProjetoApplication(private val projectRepository: ProjectRepository,
						 private val taskRepository: TaskRepository,
						 private val userRepository: UserRepository): CommandLineRunner {

	private val logger: Logger = LoggerFactory.getLogger(javaClass)
	override fun run(vararg args: String?) {
		projectRepository.deleteAll()
		taskRepository.deleteAll()
		userRepository.deleteAll()

		val coolParty = projectRepository.save(
			Project(
				created =  LocalDateTime.parse("2022-05-27T18:40"),
				name = "Stu Surprise Party",
				deadline = LocalDateTime.parse("2022-06-12T18:40"),
				description = "It is Stu's birthday. We are arranging a surprise bday for him!",
				notes = setOf("It needs to be a secret!", "No dogs allowed")
			)
		)

		val makeCake = projectRepository.save(
			Project(
				created = LocalDateTime.parse("2022-05-30T21:42"),
				name = "Make Birthday Cake",
				deadline = LocalDateTime.parse("2022-06-12T18:40"),
				description = "We need to make a cake for Stu. Preferrably strawberry jam."
			)
		)

		val singForHim = projectRepository.save(
			Project(
				created = LocalDateTime.parse("2022-06-03T15:13"),
				name = "Arrange singers for Stus Bday",
				deadline = LocalDateTime.parse("2022-06-12T18:40"),
				description = "We want the party to be entertaining. We need to arrange singers for that."
			)
		)

		coolParty.subprojects = setOf(makeCake, singForHim)
		projectRepository.save(coolParty)

		// NEO4J -- Task
		val bakeCake = taskRepository.save(
			Task(
				name="Bake a cake for Stu",
				description = "In order to have a cake, we need to bake it",
				notes = listOf("Bake cake"),
				status = true,
				deadline = LocalDateTime.parse("2022-06-11T18:40")
			)
		)

		val buy4Cake = taskRepository.save(
			Task(
				name="Buy stuff for cake",
				description = "In order to bake a cake, we need to buy the ingredients",
				notes = listOf("eggs", "milk", "flour", "sugar"),
				status = true,
				deadline = LocalDateTime.parse("2022-06-05T18:40")
			)
		)

		val hireSinger = taskRepository.save(
			Task(
				name="Call Singers",
				description = "To hire singers, we need to call them.",
				notes = listOf("11-9999-9999"),
				status = true,
				deadline = LocalDateTime.parse("2022-06-09T18:40")
			)
		)

		val decidePlace = taskRepository.save(
			Task(
				name="Decide Place",
				description = "To have the party, we need to decide the place.",
				notes = listOf("Mcdonalds", "Cool Palace", "Pizza Place"),
				deadline = LocalDateTime.parse("2022-06-11T18:40")
			)
		)

		// TASK & PROJECT
		coolParty.task_list = setOf(decidePlace)
		makeCake.task_list = setOf(bakeCake, buy4Cake)
		singForHim.task_list = setOf(hireSinger)

		projectRepository.save(coolParty)
		projectRepository.save(makeCake)
		projectRepository.save(singForHim)

		// Neo4j - User
		var viago = userRepository.save(User("Viago"))
		var deacon = userRepository.save(User("Deacon"))
		var vladislav = userRepository.save(User("Vladislav"))
//		var morrissey = userRepository.save(User("Morrissey"))
//		var siouxsie = userRepository.save(User("Siouxsie"))
//		var nick = userRepository.save(User("Nick"))
//		var shinji = userRepository.save(User("Shinji"))
//		var asuka = userRepository.save(User("Asuka"))
//		var rei = userRepository.save(User("Rei"))
//		var kaworu = userRepository.save(User("Kaworu"))
//		var misato = userRepository.save(User("Misato"))
//		var chicoBento = userRepository.save(User("Chico_Bento"))
//		var rosinha = userRepository.save(User("Rosinha"))
//		var zeLele = userRepository.save(User("Ze_Lele"))
//		var miku = userRepository.save(User("Miku"))
//		var meiko = userRepository.save(User("Meiko"))
//		var kaito = userRepository.save(User("Kaito"))

		coolParty.creator = deacon
		makeCake.creator = deacon
		singForHim.creator = deacon

		projectRepository.save(coolParty)
		projectRepository.save(makeCake)
		projectRepository.save(singForHim)

		deacon.friends = setOf(viago, vladislav)
		userRepository.save(deacon)
		deacon.projects = setOf(coolParty)
		//userRepository.save(deacon)
	}
}


fun main(args: Array<String>) {
	runApplication<ProjetoApplication>(*args)
}
