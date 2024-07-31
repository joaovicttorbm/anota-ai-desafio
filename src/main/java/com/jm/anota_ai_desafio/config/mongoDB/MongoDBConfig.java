package com.jm.anota_ai_desafio.config.mongoDB;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration //indica que ela contém métodos que definem beans que o Spring gerenciará.
public class MongoDBConfig {

    @Value("${spring.data.mongodb.uri}")//conexão em um arquivo de propriedades
    private String mongoUri;

    // interagir com o banco de dados MongoDB.
    @Bean
    public MongoDatabaseFactory mongoDatabaseFactory() {
        return new SimpleMongoClientDatabaseFactory(mongoUri);
    }

    //principal interface para acessar dados em MongoDB
    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDatabaseFactory());
    }
}
