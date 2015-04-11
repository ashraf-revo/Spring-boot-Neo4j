package org.revo.domain;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

/**
 * Created by ashraf on 4/11/15.
 */


@RelationshipEntity(type = "ARE_FRIENDS")
public class Friendship {
    @GraphId
    private Long id;
    @StartNode
    private Person person;
    @EndNode
    private Person friend;

    private int strength;

    public Friendship() {
    }

    public Friendship(Person from, Person to, int strength) {
        this.person = from;
        this.friend = to;
        this.strength = strength;
    }

    public Person getPerson() {
        return person;
    }

    public Person getFriend() {
        return friend;
    }

    public int getStrength() {
        return strength;
    }

    public Long getId() {
        return id;
    }
}