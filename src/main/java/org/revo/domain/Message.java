package org.revo.domain;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

import java.util.Date;

/**
 * Created by ashraf on 4/12/15.
 */
@NodeEntity
public class Message {
    @GraphId
    private Long id;
    private Date date;
    private String content;
    private String from;
    private String to;

    public Message() {
        this.date = new Date();
    }

    public Message(Long id) {
        this.id = id;
        this.date = new Date();
    }

    public Message(String content, String from, String to) {
        this.content = content;
        this.from = from;
        this.to = to;
        this.date = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
