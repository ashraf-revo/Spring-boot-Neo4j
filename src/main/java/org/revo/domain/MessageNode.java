package org.revo.domain;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * Created by ashraf on 4/12/15.
 */
@NodeEntity
public class MessageNode {
    @GraphId
    private Long id;

    public MessageNode() {
    }

    public MessageNode(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
