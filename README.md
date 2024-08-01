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
- [Contribuindo](#contribuindo)

## Instalação
Clone o repositório:
```bash
git clone https://github.com/joaovicttorbm/anota-ai-desafio.git

```


Install dependencies with Maven:

```bash
mvn install

```

## Configuração
Create a configuration with your runtime environment variables with your AWS Credentials that are used in application.properties:
```properties
aws.region=us-east-1
aws.accessKeyId=${AWS_KEY_ID}
aws.secretKey=${AWS_SECRET}

```

# Config Values
- AWS_KEY_ID: Your AWS Access Key ID.
- AWS_SECRET: Your AWS Secret Access Key.

# Database
- Run MongoDB using Docker Compose:
```bash
docker-compose up -d

```

- Access MongoDB admin interface (Mongo Express) at: http://localhost:8081
- Log in with username: admin, password: pass
- Create a database called product-catalog.

## Uso
Start the application with Maven:
```bash
mvn spring-boot:run

```

The API will be accessible at http://localhost:8080.

## Endpoints da API
Product API
- POST /api/product: Create a new product
- GET /api/product: Retrieve all products
- PUT /api/product/{id}: Update a product
- DELETE /api/product/{id}: Delete a product

Body for POST /api/product
```json
Copiar código
{
  "title": "Product to post in the topic",
  "description": "",
  "ownerId": "4444444",
  "categoryId": "659d558b0304df732ddd4587",
  "price": 10000
}

```

Category API
- POST /api/category: Create a new category
- GET /api/category: Retrieve all categories
- PUT /api/category/{id}: Update a category
- DELETE /api/category/{id}: Delete a category
- Body for POST /api/category

``` json
{
  "id": "393948882828",
  "title": "Test",
  "description": "",
  "ownerId": "4444444"
}

```

## Contributing
Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request to the repository.

When contributing to this project, please follow the existing code style, commit conventions, and submit your changes in a separate branch.

```css



Este modelo de README.md inclui ícones para Java, AWS e MongoDB e oferece uma visão clara sobre a instalação, configuração, uso e endpoints da API. Ajuste conforme necessário para atender às suas necessidades específicas.

```

