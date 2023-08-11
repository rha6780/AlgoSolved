package com.example.algosolved.domain;

import javax.persistence.*;

@Entity
@Table(name="Problem")
public class Problem {
    @Id
    @Column(name="id")
    @GeneratedValue
    private long id;

    @Column(name="title", nullable = false, length = 512)
    private String title;

    private String content;


    public Problem() {}

    public Problem(String title, String content) {
        super();
        this.title = title;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}


