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

		var coolParty = Project(created =  LocalDateTime.parse("2022-05-27T18:40"), name = "Stu Surprise Party" )
		var makeCake = Project(created = LocalDateTime.parse("2022-05-30T21:42"), name = "Make Birthday Cake")
		var singForHim = Project(created = LocalDateTime.parse("2022-06-03T15:13"), name = "Arrange singers for Stus Bday")
//
//		projectRepository.save(makeCake)
//		projectRepository.save(singForHim)
		coolParty.subprojects = setOf(makeCake, singForHim)
		coolParty.deadline = LocalDateTime.parse("2022-06-12T18:40")
		makeCake.deadline = LocalDateTime.parse("2022-06-12T18:40")
		singForHim.deadline = LocalDateTime.parse("2022-06-12T18:40")

		coolParty.description = "It is Stu's birthday. We are arranging a surprise bday for him!"
		makeCake.description = "We need to make a cake for Stu. Preferrably strawberry jam."
		singForHim.description = "We want the party to be entertaining. We need to arrange singers for that."

		coolParty.notes = setOf("It needs to be a secret!", "No dogs allowed")

		//projectRepository.save(coolParty)

		// NEO4J -- Task
		var bakeCake = Task(name="Bake a cake for Stu")
		var buy4Cake = Task(name="Buy stuff for cake")
		var hireSinger = Task(name="Call Singers")
		var decidePlace = Task(name="Decide Place")

		decidePlace.description = "To have the party, we need to decide the place."
		decidePlace.notes = listOf("Mcdonalds", "Cool Palace", "Pizza Place")
		decidePlace.deadline = LocalDateTime.parse("2022-06-11T18:40")

		bakeCake.description = "In order to have a cake, we need to bake it"
		bakeCake.notes = listOf("Bake cake")
		bakeCake.status = true
		bakeCake.deadline = LocalDateTime.parse("2022-06-11T18:40")

		buy4Cake.description = "In order to bake a cake, we need to buy the ingredients"
		buy4Cake.notes = listOf("eggs", "milk", "flour", "sugar")
		buy4Cake.status = true
		buy4Cake.deadline = LocalDateTime.parse("2022-06-05T18:40")

		hireSinger.description = "To hire singers, we need to call them."
		hireSinger.notes = listOf("11-9999-9999")
		hireSinger.status = true
		hireSinger.deadline = LocalDateTime.parse("2022-06-09T18:40")

		// TASK & PROJECT
		coolParty.task_list = setOf(decidePlace)
		makeCake.task_list = setOf(bakeCake, buy4Cake)
		singForHim.task_list = setOf(hireSinger)

		taskRepository.save(bakeCake)
		taskRepository.save(buy4Cake)
		taskRepository.save(hireSinger)

		// Neo4j - User
		var viago = User("Viago")
		var deacon = User("Deacon")
		var vladislav = User("Vladislav")
//		var morrissey = User("Morrissey")
//		var siouxsie = User("Siouxsie")
//		var nick = User("Nick")
//		var shinji = User("Shinji")
//		var asuka = User("Asuka")
//		var rei = User("Rei")
//		var kaworu = User("Kaworu")
//		var misato = User("Misato")
//		var chicoBento = User("Chico_Bento")
//		var rosinha = User("Rosinha")
//		var zeLele = User("Ze_Lele")
//		var miku = User("Miku")
//		var meiko = User("Meiko")
//		var kaito = User("Kaito")

		deacon.friends = setOf(viago, vladislav)
		coolParty.creator = deacon
		makeCake.creator = deacon
		singForHim.creator = deacon

		userRepository.save(viago)
		userRepository.save(deacon)
		userRepository.save(vladislav)

		projectRepository.save(makeCake)
		projectRepository.save(singForHim)
		projectRepository.save(coolParty)

		deacon.projects = setOf(coolParty)

		//projectRepository.save(coolParty)
	}
}


fun main(args: Array<String>) {
	runApplication<ProjetoApplication>(*args)
}
