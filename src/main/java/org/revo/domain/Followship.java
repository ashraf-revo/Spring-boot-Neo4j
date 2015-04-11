package org.revo.domain;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

/**
 * Created by ashraf on 4/11/15.
 */
@RelationshipEntity(type = "FOLLOW_BY")
public class Followship {
    @GraphId
    private Long id;
    @StartNode
    private Person following;
    @EndNode
    private Person followers;

    public Followship(Person following, Person followers) {
        this.following = following;
        this.followers = followers;
    }

    public Followship() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getFollowing() {
        return following;
    }

    public Person getFollowers() {
        return followers;
    }

}
