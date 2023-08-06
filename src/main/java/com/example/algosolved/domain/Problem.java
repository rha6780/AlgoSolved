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

    private String solve;

    public Problem() {}

    public Problem(String title, String solve) {
        super();
        this.title = title;
        this.solve = solve;
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

    public String getSolve() {
        return solve;
    }

    public void setSolve(String solve) {
        this.solve = solve;
    }
}


