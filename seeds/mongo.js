db = db.getSiblingDB("test");

db.communities.drop()
db.publications.drop()
db.events.drop()

db.createCollection('communities')
db.createCollection('publications')
db.createCollection('events')

// from https://www.w3resource.com/javascript-exercises/javascript-math-exercise-23.php
function create_UUID(){
    var dt = new Date().getTime();
    var uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        var r = (dt + Math.random()*16)%16 | 0;
        dt = Math.floor(dt/16);
        return (c=='x' ? r :(r&0x3|0x8)).toString(16);
    });
    return uuid;
}

// publicações
let publications = db.publications.insertMany([
	{
		"title": "Novos membros",
		"text": "Hoje nós recebemos novos membros para a nossa equipe! Sejam bem-vindos à DevGam, Kaworu e Misato.",
		"author": "Shinji",
		"creationDate": new Date("2022-03-02T14:23:44"),
		"comments": [
			{
				"_id": create_UUID(),
				"author": "Asuka",
				"creationDate": new Date("2022-03-02T15:10:20"),
				"text": "Bem-vindos ao time!",
				"likes": ["Misato"]
			},
			{
				"_id": create_UUID(),
				"author": "Rei",
				"text": "Novos membros! Precisamos muito de novas pessoas para ajudar com nossos projetos.",
				"creationDate": new Date("2022-03-02T16:10:20"),
				"likes": ["Asuka"]
			}
		]
	},
	{
		"title": "Festa Junina",
		"text": "Preciso de alunos para me ajudar com a organização da nossa festa junina, alguém disponível?",
		"author": "Chico_Bento",
		"creationDate": new Date("2022-05-30T12:34:23"),
		"comments": [
			{
				"_id": "1",
				"author": "Rosinha",
				"creationDate": new Date("2022-05-30T13:40:22"),
				"text": "Eu posso ajudar!",
				"likes": ["Chico_Bento"]
			},
			{
				"_id": create_UUID(),
				"author": "Ze_Lele",
				"creationDate": new Date("2022-05-30T13:50:22"),
				"text": "também qro organizar essa festa",
			},
			{
				"_id": create_UUID(),
				"author": "Chico_Bento",
				"creationDate": new Date("2022-05-30T18:21:14"),
				"text": "Obrigado, pessoal! Já adicionei vocês no projeto",
				"likes": ["Rosinha", "Ze_Lele"]
			}
		]
	},
	{
		"title": "D&D",
		"text": "vcs topam jogar dungeons and dragons?",
		"author": "Kaworu",
		"creationDate": new Date("2021-07-23T08:20:13"),
		"images": ["dungeons_and_dragons.png"],
		"comments": [
			{
				"_id": create_UUID(),
				"author": "Viago",
				"creationDate": new Date("2021-07-23T12:12:23"),
				"text": "bora, convidei uns amigos pra jogar também",
				"likes": ["Kaworu", "Viago"]
			}
		]
	}
]);

let events = db.events.insertMany([
	{
		"title": "Festa Junina",
		"description": "Realização da festa.",
		"creator": "Chico_Bento",
		"context": {
			"type": "project",
			"_id":  7
		},
		"status": "PENDING",
		"date": new Date("2022-06-10T18:00:00"),
		"estimatedDuration": "3 horas",
		"notes": ["Vai ter bolo!"],
		"participants": [
			{
				"_id":  "Chico_Bento",
				"confirmationDate": new Date("2022-05-290T17:12:34")
			},
			{
				"_id":  "Rosinha",
			},
			{
				"_id":  "Ze_Lele"
			}
		],
	},
	{
		"title": "Partida de D&D",
		"description": "Partida que a gente combinou.",
		"creator": "Asuka",
		"context": {
			"type": "user",
			"_id":  "Asuka"
		},
		"status": "DONE",
		"date": new Date("2021-07-26T19:00:00"),
		"estimatedDuration": "2 horas",
		"notes": ["Tragam comida"],
		"participants": [
			{
				"_id":  "Kaworu",
				"confirmationDate": new Date("2021-07-25T14:25:24")
			},
			{
				"_id":  "Viago",
				"confirmationDate": new Date("2021-07-25T12:55:27")
			},
			{
				"_id":  "Asuka",
				"confirmationDate": new Date("2021-07-25T12:27:49")
			},
			{
				"_id":  "Chico_Bento",
				"confirmationDate": new Date("2021-07-25T18:30:18")
			},
			{ 
				"_id":  "Siouxsie",
				"confirmationDate": new Date("2021-07-25T15:41:32")
			}
		],
	}
]);

db.communities.insertMany([
	{
		"name": "DevGam",
		"description": "Uma empresa de desenvolvimento de jogos.",
		"creator": "Shinji",
		"creationDate": new Date("2022-02-04T14:32:32"),
		"projects": [
			{
				"_id":  4,
				"name": "Indie Game Project"
			}
		],
		"members": [
			{
				"_id":  "Shinji",
				"entryDate": new Date("2022-02-04T14:32:32")
			},
			{
				"_id":  "Asuka",
				"entryDate": new Date("2022-02-04T16:24:31")
			},
			{
				"_id":  "Rei",
				"entryDate": new Date("2022-02-04T16:24:31")
			},
			{
				"_id":  "Kaworu",
				"entryDate": new Date("2022-03-02T11:24:31")
			},
			{
				"_id":  "Misato",
				"entryDate": new Date("2022-03-02T11:24:31")
			},
		],
		"publications": [publications.insertedIds['0']]
	},
	{
		"name": "Escola de Tubarão",
		"description": "Comunidade de alunos e professores da Escola de Tubarão.",
		"creator": "Chico_Bento",
		"creationDate": new Date("2021-10-04T09:17:49"),
		"projects": [
			{
				"_id":  7,
				"name": "Festa Junina"
			}
		],
		"members": [
			{
				"_id":  "Chico_Bento",
				"entryDate": new Date("2021-10-04T09:17:49")
			},
			{
				"_id":  "Rosinha",
				"entryDate": new Date("2021-10-04T10:12:19")
			},
			{
				"_id":  "Ze_Lele",
				"entryDate": new Date("2021-10-04T10:12:19")
			}
		],
		"events": [events.insertedIds['0']],
		"publications": [publications.insertedIds['1']]
	},
	{
		"name": "Clube de RPG",
		"description": "Reunimos pessoas interessadas em jogos do estilo RPG.",
		"creator": "Kaworu",
		"creationDate": new Date("2021-04-20T20:12:22"),
		"projects": [
			{
				"_id":  19,
				"name": "Dungeons and Dragons RPG"
			}
		],
		"members": [
			{
				"_id":  "Kaworu",
				"entryDate": new Date("2021-04-20T20:12:22")
			},
			{
				"_id":  "Viago",
				"entryDate": new Date("2021-04-22T19:43:21")
			},
			{
				"_id":  "Asuka",
				"entryDate": new Date("2021-04-22T19:43:21")
			},
			{
				"_id":  "Morrissey",
				"entryDate": new Date("2021-04-22T19:43:21")
			},
			{
				"_id":  "Chico_Bento",
				"entryDate": new Date("2021-04-22T19:43:21")
			},
			{
				"_id":  "Siouxsie",
				"entryDate": new Date("2021-04-22T19:43:21")
			}
		],
		"events": [events.insertedIds['1']],
		"publications": [publications.insertedIds['2']]
	}
]);
