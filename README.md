
# API de Terminais

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

🚧  Status: Em Produção. 🚧


API para inserir, alterar, consultar e listar dados de Terminais.

# Features:

  [x] Buscar dados de um terminal específico por Logic;
  [x] Inserir um novo terminal;
  [x] Alterar um terminal específico por Logic;
  [x] Listar todos os terminais;

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
 * Java JDK (versão LTS 11)
    * https://www.oracle.com/java/technologies/javase-downloads.html
    * Configurar variáveis de ambiente do sistema
    * Painel de Controle -> Variáveis de Ambiente
    * JAVA_HOME:
    * C:\Program Files\Java\jdk-11.0.6
    * Path: incluir
    * C:\Program Files\Java\jdk-11.0.6\bin
    * Testar no terminal de comando: java -version
    * Vídeo: https://www.youtube.com/watch?v=-LdVKkKLGkw
- STS - Spring Tool Suit (Eclipse / Maven / Tomcat / Jackson / JPA): https://spring.io/tools
- Xampp (Windows, Mac, Linux)
- Postman: https://www.postman.com/downloads/

- Acese o repositório "laislealdina/desafiotecnico" no GitHub e clique em "Code" eapós isso clique em "Download Zip". Link: https://github.com/laislealdina/desafiotecnico

### 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

* [Spring Boot] - usado para implementação de requisições e validações;
* [JPA] - usado para converter automaticamente as classes em tabelas no banco;
* [MySql] - sistema usado para o gerenciamento do banco local;

### 🎲 Rodando o Back End (servidor)

Execute o XAMPP e inicie os serviços Apache e MySql. Acesse https://localhost/dashboard/, clique em "phpMyAdmin" e crie um banco de dados local chamado "terminais".

- execute o sql: create database terminais;

Após ter baixado o projeto do Git, abra o Spring Tool Suite e acesse "File > Open Projects From System...", clique em "Directory...", selecione a pasta do projeto e clique em "Finish". O projeto aparecerá na aba "Project Explorer".

- Execute a aplicação no profile de desenvolvimento. Acesse o arquivo "application.properties" na pasta "src/main/resources" e coloque a seguinte configuração: spring.profiles.active=dev.

Dê um duplo clique na pasta do projeto "desafiotecnico" e será aberta uma hierarquia de pastas, feito isso vá em "src/main/java", abra o pacote "com.laisleal.desafiotecnico" e aparecerá o arquivo com a classe principal do projeto "DesafiotecnicoApplication.java". Clique com o botão direito nele, vá na opção "Run As" e selecione a opção "Spring Boot App".

A URL padrão onde o Spring Boot coloca o nosso projeto é: https://localcalhost:8080.
Caso a porta 8080 já esteja sendo utilizada por outro serviço, você pode matar a aplicação ou configurar para a sua aplicação funcionar em outra porta, fazendo da seguinte forma:
- Acesse "src/main/resources" > application.properties"
- Coloque: server:port=${port:8081} (No caso de querer usar a porta 8081)

### Documentação

Para acessar o swagger com a documentação da API, basta excutar a aplicação e acessar a URL: https://localcalhost:8080/swagger-ui.html

### Heroku

Para acessar a aplicação no Heroku basta colocar o link a seguir:
- https://desafio-tecnico-lais.herokuapp.com/v1/Terminal/lista

Para acessar o Swagger no Heroku basta acessar: 
- https://desafio-tecnico-lais.herokuapp.com/swagger-ui.html
