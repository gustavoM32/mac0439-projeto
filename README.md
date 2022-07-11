# Projeto de MAC0439 - Laboratório de Banco de Dados

## Comandos
* Inicia os containers com os BDs\
`docker-compose up -d`

* Para os containers\
`docker-compose stop`

* Remove os containers\
`docker-compose down`

* Abre mongosh no container do mongo\
`sudo docker exec -it <container-do-mongo> mongosh`

* Configurar IDE (Intellij) para recarregar o spring automaticamente:
  1. Em `Edit Configurations...`
     1. Em `Add New Configuration -> Gradle`, colocar `build --continuous` em `Run`
     2. Em `Add New Configuration -> Gradle`, colocar `bootRun` em `Run`
     3. Em `Add New Configuration -> Compound`, adicionar as duas configurações anteriores
     4. Clicar em `Apply`
  2. Após rodar a última configuração criada, qualquer mudança no código será refletida no spring automaticamente
  3. Adicionalmente, [essa extensão do Chrome](https://chrome.google.com/webstore/detail/livereload/jnihajbhpnppcggbcgedagnkighmdlei) atualiza a página do navegador automaticamente
