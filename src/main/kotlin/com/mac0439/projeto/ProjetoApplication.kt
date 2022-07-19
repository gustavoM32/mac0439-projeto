package com.mac0439.projeto

import com.mac0439.projeto.domain.neo4j.user.FriendsWith
import com.mac0439.projeto.domain.neo4j.project.Project
import com.mac0439.projeto.domain.neo4j.repositories.ProjectRepository
import com.mac0439.projeto.domain.neo4j.repositories.TaskRepository
import com.mac0439.projeto.domain.neo4j.repositories.UserNeoRepository
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
						 private val userNeoRepository: UserNeoRepository): CommandLineRunner {

	private val logger: Logger = LoggerFactory.getLogger(javaClass)
	override fun run(vararg args: String?) {
//		return
		projectRepository.deleteAll()
		taskRepository.deleteAll()
		userNeoRepository.deleteAll()

		val coolParty = projectRepository.save(
			Project(
				id = "33675f79-779f-43be-8213-53f6bb3d318c",
				created =  LocalDateTime.parse("2022-05-27T18:40"),
				name = "Stu Surprise Party",
				deadline = LocalDateTime.parse("2022-06-12T18:40"),
				description = "It is Stu's birthday. We are arranging a surprise bday for him!",
				notes = setOf("It needs to be a secret!", "No dogs allowed")
			)
		)

		val makeCake = projectRepository.save(
			Project(
				id = "78c53959-f6d1-4f15-82ba-b971a4c1edd5",
				created = LocalDateTime.parse("2022-05-30T21:42"),
				name = "Make Birthday Cake",
				deadline = LocalDateTime.parse("2022-06-12T18:40"),
				description = "We need to make a cake for Stu. Preferrably strawberry jam."
			)
		)

		val singForHim = projectRepository.save(
			Project(
				id = "366fa5ea-d626-4f91-a375-a9fed4132b47",
				created = LocalDateTime.parse("2022-06-03T15:13"),
				name = "Arrange singers for Stus Bday",
				deadline = LocalDateTime.parse("2022-06-12T18:40"),
				description = "We want the party to be entertaining. We need to arrange singers for that."
			)
		)

		val dungeons = projectRepository.save(
			Project(
				id = "9930cd67-3658-41ee-af01-32b4ab77bc3c",
				created = LocalDateTime.parse("2022-05-01T12:56:39"),
				name = "Dungeons and Dragons RPG",
				deadline = LocalDateTime.parse("2022-12-31T18:40"),
				description = "Organization for our RPG campaign",
			)
		)

		val gameDev = projectRepository.save(
			Project(
				id = "df84664c-e804-4614-9be4-e68652b8fcb9",
				created = LocalDateTime.parse("2022-05-27T20:40:32.142"),
				name = "Indie Game Project",
				deadline = LocalDateTime.parse("2022-12-25T18:40"),
				description = "We are an indie gam dev team. We are deveoloping a Stardew-like game!",
				notes = setOf("Stardew Valley inspired")
			)
		)

		val mainFeatures = projectRepository.save(
			Project(
				created = LocalDateTime.parse("2022-05-27T20:40:32.142"),
				name = "Programming",
				deadline = LocalDateTime.parse("2022-10-25T18:40"),
				description = "Implementation!",
				notes = setOf("using Lua programming language")
			)
		)

		val designDec = projectRepository.save(
			Project(
				created = LocalDateTime.parse("2022-05-27T20:40:32.142"),
				name = "Design",
				deadline = LocalDateTime.parse("2022-08-25T18:40"),
				description = "Design decisions!",
				notes = setOf("not kitsch")
			)
		)

		val festaJunina = projectRepository.save(
			Project(
				id = "da771c27-19b1-416a-b964-dbd4443781c9",
				created = LocalDateTime.parse("2022-05-30T10:40:30"),
				name = "Festa Junina",
				deadline = LocalDateTime.parse("2022-06-10T18:40"),
				status = true,
				description = "Estamos organizando uma festa junina para arrecadar recursos para nossa escola.",
				notes = setOf("Entretenimento")
			)
		)

		val gamesDecision = projectRepository.save(
			Project(
				created = LocalDateTime.parse("2022-05-30T10:40:30"),
				name = "Decisão dos Jogos",
				deadline = LocalDateTime.parse("2022-06-10T18:40"),
				status = true,
				description = "Precisamos decidir quais jogos vão estar disponíveis para jogar na festa.",
			)
		)

		val pescaria = projectRepository.save(
			Project(
				name = "Pescaria",
				description = "A pescaria é uma opção de jogo.",
				status = true,
				notes = setOf("Comprar coisas", "Pintar as coisas"),
				deadline = LocalDateTime.parse("2022-06-09T18:40"),
				created = LocalDateTime.parse("2022-05-30T10:40:30"),
			)
		)

		val tiroAoAlvo = projectRepository.save(
			Project(
				name = "Tiro ao Alvo",
				description = "Tiro ao alvo é uma opção de jogo.",
				status = true,
				notes = setOf("Comprar coisas"),
				deadline = LocalDateTime.parse("2022-06-09T18:40"),
				created = LocalDateTime.parse("2022-05-30T10:40:30"),
			)
		)

		val touroMecanico = projectRepository.save(
			Project(
				name = "Touro mecânico",
				description = "Touro mecânico é uma opção de jogo.",
				status = true,
				notes = setOf("Alugar as coisas"),
				deadline = LocalDateTime.parse("2022-06-09T18:40"),
				created = LocalDateTime.parse("2022-05-30T10:40:30"),
			)
		)


		// NEO4J -- Task
		val bakeCake = taskRepository.save(
			Task(
				id = "beecdd7c-167d-43e2-a39b-86a6dacc84a9",
				name="Bake a cake for Stu",
				description = "In order to have a cake, we need to bake it",
				notes = listOf("Bake cake"),
				status = true,
				deadline = LocalDateTime.parse("2022-06-11T18:40")
			)
		)

		val buy4Cake = taskRepository.save(
			Task(
				id = "f2743afb-bbac-450d-9f36-df7bfe44c64b",
				name="Buy stuff for cake",
				description = "In order to bake a cake, we need to buy the ingredients",
				notes = listOf("eggs", "milk", "flour", "sugar"),
				status = true,
				deadline = LocalDateTime.parse("2022-06-05T18:40")
			)
		)

		val hireSinger = taskRepository.save(
			Task(
				id = "288640b7-5814-451e-8542-fac9442d4a75",
				name="Call Singers",
				description = "To hire singers, we need to call them.",
				notes = listOf("11-9999-9999"),
				status = true,
				deadline = LocalDateTime.parse("2022-06-09T18:40")
			)
		)

		val decidePlace = taskRepository.save(
			Task(
				id = "59aa8196-0f2c-4e0d-872c-9491ab30a0fb",
				name="Decide Place",
				description = "To have the party, we need to decide the place.",
				notes = listOf("Mcdonalds", "Cool Palace", "Pizza Place"),
				deadline = LocalDateTime.parse("2022-06-11T18:40")
			)
		)

		val createMap = taskRepository.save(
			Task(
				name="Create Open World",
				description = "In order to have an RPG, we need a world for it",
				notes = listOf("Build a map"),
				deadline = LocalDateTime.parse("2022-06-28T18:40")
			)
		)

		val designMap = taskRepository.save(
			Task(
				name="Create Map Design",
				description = "Design decisions of the game's landscape",
				notes = listOf("Design a Map for exploration"),
				status = true,
				deadline = LocalDateTime.parse("2022-06-28T18:40")
			)
		)

		val killGoblin = taskRepository.save(
			Task(
				id = null,
				name= "Party needs to kill goblin",
				description = "Goblins are blocking the way. Kill them.",
				notes = listOf("50xp"),
				status = true,
				deadline = LocalDateTime.parse("2022-06-11T18:40")
			)
		)

		val decideGames = taskRepository.save(
			Task(
				name = "Decidir os jogos",
				description = "Decidir os jogos para o arraial",
				status = true,
				notes = listOf("Pescaria", "Tiro ao Alvo", "Touro Mecanico"),
				deadline = LocalDateTime.parse("2022-06-01T18:00:00"),
			)
		)

		val buy4Pescaria = taskRepository.save(
			Task(
				name = "Comprar para a pescaria",
				description = "Comprar coisas para a pescaria",
				status = true,
				notes = listOf("4 anzóis", "Tinta azul", "Piscina inflável", "10kg de areia", "Tinta vermelha", "Papel crepe"),
				deadline = LocalDateTime.parse("2022-06-03T18:00:00"),
			)
		)

		val diyPescaria = taskRepository.save(
			Task(
				name = "DIY Pescaria",
				description = "Seguir as etapas para criar as ferramentas para o jogo",
				status = true,
				notes = listOf("Cortar peixes", "Pintar peixes", "Ligar o gancho no peixe"),
				deadline = LocalDateTime.parse("2022-06-04T18:00:00"),
			)
		)

		val set4Pescaria = taskRepository.save(
			Task(
				name = "Construir o jogo da pescaria",
				description = "Juntar tudo que foi comprado para o jogo ficar funcional.",
				status = true,
				notes = listOf("Inflar piscina", "Encher piscina com areia", "Criar 'mar' com papel crepe"),
				deadline = LocalDateTime.parse("2022-06-04T18:00:00"),
			)
		)

		val diyTiroAlvo = taskRepository.save(
			Task(
				name = "DIY Tiro ao Alvo",
				description = "Seguir as etapas para criar as ferramentas para o jogo",
				status = true,
				notes = listOf("Conseguir 10 bolas", "Conseguir 20 latas", "Pintar latas"),
				deadline = LocalDateTime.parse("2022-06-03T18:00:00"),
			)
		)

		val set4TiroAoAlvo = taskRepository.save(
			Task(
				name = "Preparar o lugar",
				description = "Preparar o lugar, organizar as coisas e colocar o alvo",
				status = true,
				notes = listOf("Desenhar no papel antes de começar"),
				deadline = LocalDateTime.parse("2022-06-04T18:00:00"),
			)
		)

		val rentTouro = taskRepository.save(
			Task(
				name = "Alugar o touro mecânico",
				description = "Procurar lugar com um preço bom",
				status = true,
				notes = listOf("Ligar para quem aluga", "Receber o touro"),
				deadline = LocalDateTime.parse("2022-06-09T18:00:00"),
			)
		)


		// SUBPROJECTS
		coolParty.subprojects = setOf(makeCake, singForHim)
		gameDev.subprojects = setOf(mainFeatures, designDec)
		festaJunina.subprojects = setOf(gamesDecision)
		gamesDecision.subprojects = setOf(pescaria, tiroAoAlvo, touroMecanico)
		projectRepository.save(coolParty)
		projectRepository.save(gameDev)
		projectRepository.save(festaJunina)
		projectRepository.save(gamesDecision)

		// TASK & PROJECT
		coolParty.task_list = setOf(decidePlace)
		makeCake.task_list = setOf(bakeCake, buy4Cake)
		singForHim.task_list = setOf(hireSinger)

		gameDev.task_list = setOf(createMap)
		dungeons.task_list = setOf(killGoblin)
		gamesDecision.task_list = setOf(decideGames)
		pescaria.task_list = setOf(buy4Pescaria, diyPescaria, set4Pescaria)
		tiroAoAlvo.task_list = setOf(diyTiroAlvo, set4TiroAoAlvo)
		touroMecanico.task_list = setOf(rentTouro)

		projectRepository.save(coolParty)
		projectRepository.save(makeCake)
		projectRepository.save(singForHim)
		projectRepository.save(gameDev)
		projectRepository.save(dungeons)
		projectRepository.save(gamesDecision)
		projectRepository.save(pescaria)
		projectRepository.save(tiroAoAlvo)
		projectRepository.save(touroMecanico)

		createMap.subtasks = setOf(designMap)
		decideGames.subtasks = setOf(buy4Pescaria, diyPescaria, set4Pescaria, diyTiroAlvo, set4TiroAoAlvo, rentTouro)

		taskRepository.save(createMap)
		taskRepository.save(decideGames)

		// Neo4j - User
		val viago = userNeoRepository.save(User("Viago"))
		val deacon = userNeoRepository.save(User("Deacon"))
		val vladislav = userNeoRepository.save(User("Vladislav"))

		val morrissey = userNeoRepository.save(User("Morrissey"))
		val siouxsie = userNeoRepository.save(User("Siouxsie"))
		val nick = userNeoRepository.save(User("Nick"))
		val shinji = userNeoRepository.save(User("Shinji"))
		val asuka = userNeoRepository.save(User("Asuka"))
		val rei = userNeoRepository.save(User("Rei"))
		val kaworu = userNeoRepository.save(User("Kaworu"))
		val misato = userNeoRepository.save(User("Misato"))
		val chicoBento = userNeoRepository.save(User("Chico_Bento"))
		val rosinha = userNeoRepository.save(User("Rosinha"))
		val zeLele = userNeoRepository.save(User("Ze_Lele"))
		val miku = userNeoRepository.save(User("Miku"))
		val meiko = userNeoRepository.save(User("Meiko"))
		val kaito = userNeoRepository.save(User("Kaito"))


		coolParty.creator = deacon
		makeCake.creator = deacon
		singForHim.creator = deacon

		gameDev.member = setOf(shinji, asuka, rei, kaworu, misato)
		gameDev.creator = shinji

		mainFeatures.member = setOf(shinji, asuka, rei)
		mainFeatures.creator = shinji

		designDec.member = setOf(shinji, asuka)
		designDec.creator = misato

		dungeons.member = setOf(viago, asuka, kaworu, morrissey, chicoBento, siouxsie)
		dungeons.creator = kaworu

		festaJunina.member = setOf(chicoBento, rosinha, zeLele)
		festaJunina.creator = chicoBento

		gamesDecision.member = setOf(chicoBento, rosinha, zeLele)
		gamesDecision.creator = chicoBento

		pescaria.member = setOf(zeLele, rosinha)
		pescaria.creator = zeLele

		tiroAoAlvo.member = setOf(zeLele, rosinha)
		tiroAoAlvo.creator = zeLele

		touroMecanico.member = setOf(chicoBento)
		touroMecanico.creator = chicoBento

		projectRepository.save(coolParty)
		projectRepository.save(makeCake)
		projectRepository.save(singForHim)
		projectRepository.save(gameDev)
		projectRepository.save(dungeons)
		projectRepository.save(festaJunina)
		projectRepository.save(gamesDecision)
		projectRepository.save(pescaria)
		projectRepository.save(tiroAoAlvo)
		projectRepository.save(touroMecanico)

//		deacon.projects = setOf(MemberOf(project = coolParty))
		deacon.friends = setOf(
			FriendsWith(user = viago),
			FriendsWith(user = vladislav)
		)
		userNeoRepository.save(deacon)
	}
}


fun main(args: Array<String>) {
	runApplication<ProjetoApplication>(*args)
}
