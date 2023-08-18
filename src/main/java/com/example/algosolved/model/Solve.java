package com.example.algosolved.model;


import javax.persistence.*;

@Entity
public class Solve {
    @Id
    @Column(name="id")
    @GeneratedValue
    private long id;

    @Column(name = "problem_id")
    private long problemId;

    private String content;

    private long time;

    private String language;
}
