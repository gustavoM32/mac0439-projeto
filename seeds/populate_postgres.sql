INSERT INTO Usuario
  (nome_usuario, nome, senha, email, nascimento, biografia)
VALUES
  ('Viago', 'Viago Taika Waititi', 'viagospass123', 'viago.taika@email.com', '1975-05-16', 'Olá, meu nome é Viago.'),
  ('Deacon', 'Deacon Jonathan Brugh', 'lilly1999', 'deaconbrugh@email.com', '1970-04-25', 'Bem vindo ao meu perfil, meu nome é Deacon'),
  ('Vladislav', 'Vladislav Jemaine Clement', 'vlad@155#', 'vlad.clement@mymail.com', '1974-01-10', 'Tenho 48 anos e sou novo por aqui.'),
  ('Morrissey', 'Steven Patrick Morrissey', 'interlude121994', 'morrissey_steven@email.com', '1959-05-22', 'Olá, meu nome é Steven.'),
  ('Siouxsie', 'Susan Janet Ballion', 'sioux.london173', 'sioxsie_official@myemail.com', '1957-05-27', 'Siouxine Sioux.');

INSERT INTO Usuario
  (nome_usuario, nome, senha, email, nascimento, biografia)
VALUES
  ('Shinji', 'Shinji Ikari', 'shinjiiiNeon', 'shinjiiikari@mymail.com.jp', '2001-06-06', NULL),
  ('Asuka', 'Asuka Langley Soryu', 'unit@evan02', 'asuka.langley@pmail.com.jp', '2001-12-04', 'Sei falar alemão e nasci nos EUA.'),
  ('Rei', 'Rei Ayanami', 'pilot-00', 'ReiAyanami@email.com.jp', '2001-04-02', 'Bem vindo ao meu perfil, meu nome é Rei.'),
  ('Kaworu', 'Kaworu Nagisa', 'trabris-5-17', 'nagisa.kaworu@pmail.com.jp', '2000-09-13', NULL),
  ('Misato', 'Misato Katsuragi', 'gainax.54', 'misatoo01@mymail.com.jp', '1993-01-23', NULL);

INSERT INTO Usuario
  (nome_usuario, nome, senha, email, nascimento, biografia)
VALUES
  ('Chico_Bento', 'Chico Bento', 'chiquinho@321', 'chico.turma@mail.com.br', '1992-04-12', 'Gosto muito de goiaba.'),
  ('Rosinha', 'Rosinha', '312rosasinha2', 'rosinhacaipira@mail.com.br', '1992-11-03', NULL),
  ('Ze_Lele', 'Ze Lele', 'zelele@123', 'ze.le.le@myemail.com.br', '1992-05-01', 'Bem vindo ao meu perfil, meu nome é Ze Lele.');

INSERT INTO Usuario
  (nome_usuario, nome, senha, email, nascimento, biografia)
VALUES
  ('Miku', 'Hatsune Miku', 'ievan..polkka', 'hatsune.miku@pmail.com.jp', '2002-07-31', 'Adoro cantar e comer aipo.'),
  ('Meiko', 'Meiko', '1meiko2diva3', 'meiko.voca@pmail.com.jp', '2000-10-09', 'Bem vindo ao meu perfil, meu nome é Meiko.'),
  ('Kaito', 'Kaito', 'taro_kaito', 'kaito.loid@mymail.com.jp', '2003-07-15', NULL);


INSERT INTO Habilidade (identificador, nome, descricao) VALUES
  (1, 'Perfil Completo', 'Finalize completamente a criação do seu perfil.'),
  (2, 'Missão Dada', 'Crie sua primeira tarefa.'),
  (3, 'Missão Cumprida', 'Finalize sua primeira tarefa.'),
  (4, 'Mudei de Ideia', 'Delete sua primeira tarefa.'),
  (5, 'Detalhista', 'Crie uma subtarefa de uma subtarefa.'),
  (6, 'Projetista', 'Crie seu primeiro projeto.'),
  (7, 'Projetista minucioso', 'Crie seu primeiro subprojeto.'),
  (8, 'Pau pra toda obra I', 'Finalize 10 tarefas.'),
  (9, 'Pau pra toda obra II', 'Finalize 100 tarefas.'),
  (10, 'Pau pra toda obra III', 'Finalize 1000 tarefas.'),
  (11, 'Líder de Projeto I', 'Crie 5 projetos'),
  (12, 'Líder de Projeto II', 'Crie 15 projetos'),
  (13, 'Líder de Projeto III', 'Crie 50 projetos'),
  (14, 'Comunitário', 'Crie uma comunidade'),
  (15, 'Sociável', 'Faça parte de uma comunidade'),
  (16, 'Participador I', 'Faça 100 comentários em tarefas/projetos/comunidades'),
  (17, 'Participador II', 'Faça 500 comentários em tarefas/projetos/comunidades'),
  (18, 'Participador III', 'Faça 2000 comentários em tarefas/projetos/comunidades');

INSERT INTO Possui_Habilidade (nome_usuario, identificador) VALUES
  ('Viago', 1),
  ('Viago', 2),
  ('Viago', 3),
  ('Viago', 4),
  ('Viago', 8),
  ('Viago', 5),
  ('Viago', 15),

  ('Deacon', 1),
  ('Deacon', 2),
  ('Deacon', 5),
  ('Deacon', 6),
  ('Deacon', 7),
  ('Deacon', 11),
  ('Deacon', 12),
  ('Deacon', 16),

  ('Vladislav', 1),
  ('Vladislav', 2),
  ('Vladislav', 3),
  ('Vladislav', 4),
  ('Vladislav', 8),
  ('Vladislav', 9),
  ('Vladislav', 10),
  ('Vladislav', 15),
  ('Vladislav', 16),
  ('Vladislav', 17),

  ('Morrissey', 1),
  ('Morrissey', 2),
  ('Morrissey', 3),
  ('Morrissey', 4),
  ('Morrissey', 5),
  ('Morrissey', 6),
  ('Morrissey', 8),
  ('Morrissey', 9),
  ('Morrissey', 11),
  ('Morrissey', 15),
  ('Morrissey', 16),

  ('Siouxsie', 1),
  ('Siouxsie', 2),
  ('Siouxsie', 3),
  ('Siouxsie', 4),
  ('Siouxsie', 5),
  ('Siouxsie', 6),
  ('Siouxsie', 7),
  ('Siouxsie', 8),
  ('Siouxsie', 9),
  ('Siouxsie', 10),
  ('Siouxsie', 11),
  ('Siouxsie', 12),
  ('Siouxsie', 14),
  ('Siouxsie', 15),
  ('Siouxsie', 16),
  ('Siouxsie', 17),
  ('Siouxsie', 18),

  ('Shinji', 2),
  ('Shinji', 3),
  ('Shinji', 8),
  ('Shinji', 9),
  ('Shinji', 10),
  ('Shinji', 15),
  ('Shinji', 16),
  ('Shinji', 17),
  ('Shinji', 18),

  ('Asuka', 1),
  ('Asuka', 2),
  ('Asuka', 3),
  ('Asuka', 4),
  ('Asuka', 5),
  ('Asuka', 8),
  ('Asuka', 9),
  ('Asuka', 15),
  ('Asuka', 16),
  ('Asuka', 17),

  ('Rei', 1),
  ('Rei', 2),
  ('Rei', 3),
  ('Rei', 4),
  ('Rei', 6),
  ('Rei', 7),
  ('Rei', 8),
  ('Rei', 11),
  ('Rei', 12),
  ('Rei', 14),
  ('Rei', 15),
  ('Rei', 16),
  ('Rei', 17),
  ('Rei', 18),

  ('Kaworu', 2),

  ('Misato', 15),

  ('Chico_Bento', 1),
  ('Chico_Bento', 2),
  ('Chico_Bento', 3),
  ('Chico_Bento', 4),
  ('Chico_Bento', 5),
  ('Chico_Bento', 6),
  ('Chico_Bento', 7),
  ('Chico_Bento', 8),
  ('Chico_Bento', 9),
  ('Chico_Bento', 11),
  ('Chico_Bento', 14),
  ('Chico_Bento', 15),
  ('Chico_Bento', 16),
  ('Chico_Bento', 17),

  ('Rosinha', 2),
  ('Rosinha', 3),
  ('Rosinha', 5),
  ('Rosinha', 15),
  ('Rosinha', 16),

  ('Ze_Lele', 1),
  ('Ze_Lele', 2),
  ('Ze_Lele', 3),
  ('Ze_Lele', 5),
  ('Ze_Lele', 6),
  ('Ze_Lele', 8),
  ('Ze_Lele', 15),

  ('Miku', 1),
  ('Miku', 2),
  ('Miku', 3),
  ('Miku', 4),
  ('Miku', 5),
  ('Miku', 6),
  ('Miku', 7),
  ('Miku', 8),
  ('Miku', 9),
  ('Miku', 15),
  ('Miku', 16),
  ('Miku', 17),

  ('Meiko', 1),
  ('Meiko', 2),
  ('Meiko', 3),
  ('Meiko', 5),
  ('Meiko', 8),
  ('Meiko', 9),
  ('Meiko', 10),
  ('Meiko', 15),
  ('Meiko', 16),

  ('Kaito', 3),
  ('Kaito', 8),
  ('Kaito', 15);
