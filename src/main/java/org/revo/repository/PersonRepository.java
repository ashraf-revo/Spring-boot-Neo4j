package org.revo.repository;

import org.revo.domain.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import java.util.List;

/**
 * Created by ashraf on 4/11/15.
 */
public interface PersonRepository extends GraphRepository<Person> {
    Person findByName(String name);

    @Query(value = "MATCH (:Person{name:{0}})<-[:ARE_FRIENDS]->(P:Person) RETURN DISTINCT P")
    List<Person> frinds(String name);

    @Query(value = "MATCH (:Person{name:{0}})-[:FOLLOW_BY]->(P:Person) RETURN DISTINCT P")
    List<Person> follower(String name);

    @Query(value = "MATCH (:Person{name:{0}})<-[:FOLLOW_BY]-(P:Person) RETURN DISTINCT P")
    List<Person> follwoings(String name);

    @Query(value =
            "MATCH (M{ name:{0}})-[:ARE_FRIENDS*2..2]-(P) WHERE NOT (M)-[:ARE_FRIENDS]-(P) RETURN DISTINCT P")
    List<Person> sugestFrindes(String name);

}
