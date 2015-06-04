package org.revo.domain;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

/**
 * Created by ashraf on 4/12/15.
 */
@RelationshipEntity(type = "MESSAGENODESHIP")
public class MessageNodeship {
    @GraphId
    private Long id;
    @StartNode
    private Person person;
    @EndNode
    private Message message;

    public MessageNodeship() {
    }

    public MessageNodeship(Person person, Message message) {
        this.person = person;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
