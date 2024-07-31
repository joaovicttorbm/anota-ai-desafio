markdown
Copiar código
# Restaurant Marketplace AnotaAi Backend Challenge

This project is an API built using Java Spring, MongoDB, and AWS services (AWS Simple Queue Service and AWS Simple Storage Service).

## Table of Contents
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Database](#database)
- [Contributing](#contributing)

## Installation
Clone the repository:
```bash
git clone https://github.com/joaovicttorbm/anota-ai-desafio.git
Install dependencies with Maven:

bash
Copiar código
mvn install
Configuration
Create a configuration with your runtime environment variables with your AWS Credentials that are used in application.properties:

properties
Copiar código
aws.region=us-east-1
aws.accessKeyId=${AWS_KEY_ID}
aws.secretKey=${AWS_SECRET}
Config Values
AWS_KEY_ID: Your AWS Access Key ID.
AWS_SECRET: Your AWS Secret Access Key.
Database
Run MongoDB using Docker Compose:
bash
Copiar código
docker-compose up -d
Access MongoDB admin interface (Mongo Express) at: http://localhost:8081
Log in with username: admin, password: pass
Create a database called product-catalog.
Usage
Start the application with Maven:

bash
Copiar código
mvn spring-boot:run
The API will be accessible at http://localhost:8080.

API Endpoints
Product API
POST /api/product: Create a new product
GET /api/product: Retrieve all products
PUT /api/product/{id}: Update a product
DELETE /api/product/{id}: Delete a product
Body for POST /api/product
json
Copiar código
{
  "title": "Product to post in the topic",
  "description": "",
  "ownerId": "4444444",
  "categoryId": "659d558b0304df732ddd4587",
  "price": 10000
}
Category API
POST /api/category: Create a new category
GET /api/category: Retrieve all categories
PUT /api/category/{id}: Update a category
DELETE /api/category/{id}: Delete a category
Body for POST /api/category
json
Copiar código
{
  "id": "393948882828",
  "title": "Test",
  "description": "",
  "ownerId": "4444444"
}
Contributing
Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request to the repository.

When contributing to this project, please follow the existing code style, commit conventions, and submit your changes in a separate branch.

vbnet
Copiar código

Feel free to adjust the URLs, credentials, and any other specific details according to your project's setup and requirements. This README.md provides a clear structure for users and contributors to understand and engage with your project effectively.







Run in terminal:
docker compose up -d
Create a DB for mongo using mongo express: http://localhost:8081.

Log with admin:pass and create a database called 'product-catalog'.

Usage
Start the application with Maven
The API will be accessible at http://localhost:8080
API Endpoints
The API provides the following endpoints:

API PRODUCT

POST /api/product - Create a new product
GET /api/product - Retrieve all products
PUT /api/product/{id} - Updates a product
DELETE /api/product/{id} - Delete a product
BODY

{
  "title": "Produto para postar no tópico",
  "description": "",
  "ownerId": "4444444",
  "categoryId": "659d558b0304df732ddd4587",
  "price": 10000
}
API CATEGORY

POST /api/category - Create a new category
GET /api/category - Retrieve all categories
PUT /api/category/{id} - Updates a category
DELETE /api/category/{id} - Delete a category
BODY

{
  "id": "393948882828",
  "title": "Teste",
  "description": "",
  "ownerId": "4444444"
}
Contributing
Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request to the repository.

When contributing to this project, please follow the existing code style, commit conventions, and submit your changes in a separate branch.
