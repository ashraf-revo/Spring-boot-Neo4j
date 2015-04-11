package org.revo.repository;

import org.revo.domain.Person;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by ashraf on 4/11/15.
 */
public interface PersonRepository extends GraphRepository<Person> {
    Person findByName(String name);
}
