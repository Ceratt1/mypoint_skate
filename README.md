# Mypoint Skate

> API em construção para gerenciamento de pontos de skate

## Tecnologias utilizadas

* [Spring Boot](https://spring.io/projects/spring-boot)
* [Spring Security](https://spring.io/projects/spring-security)
* [Swagger](https://swagger.io/)
* [Docker](https://www.docker.com/)

## Como executar

1. Clone o repositório
2. Execute `docker-compose up` na pasta raiz do projeto
3. Acesse a API em `http://localhost:8080`

## Endpoints

* `POST /skaters` - Cria um novo skatista
* `GET /skaters` - Retorna a lista de skatistas
* `GET /skaters/{id}` - Retorna um skatista específico
* `PUT /skaters/{id}` - Atualiza um skatista específico
* `DELETE /skaters/{id}` - Deleta um skatista específico

* `POST /points` - Cria um novo ponto
* `GET /points` - Retorna a lista de pontos
* `GET /points/{id}` - Retorna um ponto específico
* `PUT /points/{id}` - Atualiza um ponto específico
* `DELETE /points/{id}` - Deleta um ponto específico

## Ainda em construção

* Deploy em servidor de produção
* Autenticação e autorização com Spring Security
* Documentação com Swagger

## Contribuição

Contribuições são bem-vindas! Se você tiver alguma ideia ou deseja ajudar a melhorar a API, por favor, faça um fork do repositório e envie um pull request.
