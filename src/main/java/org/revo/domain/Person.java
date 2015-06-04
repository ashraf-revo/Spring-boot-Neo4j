package org.revo.domain;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

import org.springframework.data.neo4j.annotation.RelatedToVia;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ashraf on 4/11/15.
 */
@NodeEntity
public class Person {
    @GraphId
    private Long id;
    private String name;
    @RelatedToVia(type = "ARE_FRIENDS", direction = Direction.BOTH)
    private Set<Friendship> friends = new HashSet<>();
    @RelatedToVia(type = "FOLLOW_BY", direction = Direction.OUTGOING)
    private Set<Followship> followers = new HashSet<>();

    public Person() {
    }

    public Person(String name) {
        this();
        this.name = name;
    }

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Set<Followship> getFollowers() {
        return followers;
    }

    public Set<Friendship> getFriends() {
        return friends;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}