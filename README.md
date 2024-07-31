# Restaurant Marketplace AnotaAi Backend Challenge

![Java](https://img.shields.io/badge/Java-007396?logo=java&logoColor=white)
![AWS](https://img.shields.io/badge/AWS-232F3E?logo=amazon-aws&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-4EA94B?logo=mongodb&logoColor=white)

Este projeto é uma API construída usando Java Spring, MongoDB e serviços da AWS (AWS Simple Queue Service e AWS Simple Storage Service).

## Tabela de Conteúdos
- [Instalação](#instalação)
- [Configuração](#configuração)
- [Uso](#uso)
- [Endpoints da API](#endpoints-da-api)
- [Banco de Dados](#banco-de-dados)
- [Contribuindo](#contribuindo)

## Instalação
Clone o repositório:
```bash
git clone https://github.com/joaovicttorbm/anota-ai-desafio.git

Install dependencies with Maven:
```bash
mvn install

## Configuração
Create a configuration with your runtime environment variables with your AWS Credentials that are used in application.properties:
```properties
aws.region=us-east-1
aws.accessKeyId=${AWS_KEY_ID}
aws.secretKey=${AWS_SECRET}

# Config Values
- AWS_KEY_ID: Your AWS Access Key ID.
- AWS_SECRET: Your AWS Secret Access Key.

# Database
- Run MongoDB using Docker Compose:
```bash
docker-compose up -d

- Access MongoDB admin interface (Mongo Express) at: http://localhost:8081
- Log in with username: admin, password: pass
- Create a database called product-catalog.

## Uso
Start the application with Maven:
```bash
mvn spring-boot:run


