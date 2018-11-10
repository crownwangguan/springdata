package com.crown.university.university.config;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
    @Autowired
    private MongoProperties mongoProperties;

    private Morphia morphia() {
        final Morphia morphia = new Morphia();
        // tell Morphia where to find your classes
        morphia.mapPackage("com.crown.university.university.domain");
        return morphia;
    }

    @Bean
    public Datastore datastore(MongoClient mongoClient) {
        final Datastore datastore = morphia().createDatastore(mongoClient, mongoProperties.getDatabase());
        datastore.ensureIndexes();
        return datastore;
    }
}
