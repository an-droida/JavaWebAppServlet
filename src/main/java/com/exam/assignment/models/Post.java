package com.exam.assignment.models;

import java.sql.Timestamp;

public class Post {
    private int id;
    private String title;
    private String author;
    private String content;
    private Timestamp created_at;

    public Post(){}

    public Post(int id, String title, String author, String content, Timestamp created_at) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
