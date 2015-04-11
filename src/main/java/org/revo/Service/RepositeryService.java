package org.revo.Service;

import org.revo.domain.*;

import org.revo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ashraf on 4/11/15.
 */
@Service
@Transactional
public class RepositeryService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    private Neo4jTemplate template;

    public void mytest1() {


        List<Person> personList = Arrays.asList(
                new Person("ashraf"),
                new Person("revo"),
                new Person("adel"),
                new Person("mac"),
                new Person("noor"));
        personRepository.save(personList);
        areFrinds(personList.get(2).getName(), personList.get(3).getName());
        areFrinds(personList.get(0).getName(), personList.get(3).getName());
        areFrinds(personList.get(2).getName(), personList.get(4).getName());
        areFrinds(personList.get(0).getName(), personList.get(2).getName());
        areFrinds(personList.get(1).getName(), personList.get(2).getName());
        areFrinds(personList.get(1).getName(), personList.get(3).getName());
        areFrinds(personList.get(1).getName(), personList.get(0).getName());

        isFollowed(personList.get(0).getName(), Arrays.asList(new Person("adel"),
                new Person("mac")
        ));
        isFollowed(personList.get(1).getName(), Arrays.asList(new Person("adel"),
                new Person("mac"),
                new Person("ashraf"),
                new Person("noor")
        ));

    }

    private void isFollowed(String name, List<Person> personList) {
        Person byName = personRepository.findByName(name);
        for (Person p : personList) {
            template.createRelationshipBetween(byName,
                    personRepository.findByName(p.getName()), Followship.class, "FOLLOW_BY", false);
        }

    }


    private void areFrinds(String name1, String name2) {
        template.createRelationshipBetween(personRepository.findByName(name1),
                personRepository.findByName(name2), Friendship.class, "ARE_FRIENDS", false);
    }


}
