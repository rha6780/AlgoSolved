package com.example.algosolved.domain.solve;


import javax.persistence.*;

@Entity
@Table
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
