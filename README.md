# Projeto de MAC0439 - Laboratório de Banco de Dados

## Comandos

* Constrói as imagens necessárias\
`docker-compose build`

* Inicia os containers com os BDs\
`docker-compose --profile dbs up -d`

* Inicia os containers com o spring\
`docker-compose --profile dev up -d`

* Inicia todos os containers\
`docker-compose --profile all up -d`

* Para os containers\
`docker-compose stop`

* Remove os containers\
`docker-compose down`

* Abre mongosh no container do mongo\
`sudo docker exec -it lbd_mongo mongosh`

* Abre interface do Neo4J\
`http://localhost:7474/`

* Abre logs de um container\
`docker-compose logs -f <serviço>`

* Recompila com qualquer mudança\
`./gradlew build --continuous`

* Abre servidor\
`./gradlew bootRun`

* Configurar IDE (Intellij) para recarregar o spring automaticamente:
  1. Em `Edit Configurations...`
     1. Em `Add New Configuration -> Gradle`, colocar `build --continuous` em `Run`
     2. Em `Add New Configuration -> Gradle`, colocar `bootRun` em `Run`
     3. Em `Add New Configuration -> Compound`, adicionar as duas configurações anteriores
     4. Clicar em `Apply`
  2. Após rodar a última configuração criada, qualquer mudança no código será refletida no spring automaticamente
  3. Adicionalmente, [essa extensão do Chrome](https://chrome.google.com/webstore/detail/livereload/jnihajbhpnppcggbcgedagnkighmdlei) atualiza a página do navegador automaticamente
