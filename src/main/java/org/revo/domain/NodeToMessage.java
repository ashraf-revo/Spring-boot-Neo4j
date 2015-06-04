package org.revo.domain;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

/**
 * Created by ashraf on 4/12/15.
 */
@RelationshipEntity(type = "NODETOMESSAGE")
public class NodeToMessage {
    @GraphId
    private Long id;
    @StartNode
    private MessageNode messageNode;
    @EndNode
    private Message message;

    public NodeToMessage() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MessageNode getMessageNode() {
        return messageNode;
    }

    public void setMessageNode(MessageNode messageNode) {
        this.messageNode = messageNode;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
