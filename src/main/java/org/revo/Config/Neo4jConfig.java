package org.revo.Config;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.rest.SpringRestGraphDatabase;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableNeo4jRepositories("org.revo.repository")
public class Neo4jConfig extends Neo4jConfiguration {

    private final String storeDirectory = "/home/ashraf/prog/neo4j-community-2.1.8/data/graph.db";

    public Neo4jConfig() {
        setBasePackage("org.revo.domain");
    }

    @Bean
    public GraphDatabaseService graphDatabaseService() {
        return new SpringRestGraphDatabase("http://localhost:7474/db/data/","revo","revo");
//        return new GraphDatabaseFactory().newEmbeddedDatabase(storeDirectory);
    }

}
