Restaurant Marketplace
AnotaAi Backend Challenge
Java Spring Licence MongoDB AWS

This project is an API built using Java, Java Spring, AWS Simple Queue Service, Mongo DB and AWS Simple Storage Service.


Table of Contents
Installation
Configuration
Usage
API Endpoints
Database
Contributing
Installation
Clone the repository:
git clone https://github.com/joaovicttorbm/anota-ai-desafio.git
Install dependencies with Maven

Create a configuration with your runtime environment variables with your AWS Credentials that are used in application.properties

aws.region=us-east-1
aws.accessKeyId=${AWS_KEY_ID}
aws.secretKey=${AWS_SECRET}
Config Values

AWS_KEY_ID=VALUE;AWS_SECRET=VALUE2
Mongo

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
