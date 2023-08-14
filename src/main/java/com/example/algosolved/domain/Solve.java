package com.example.algosolved.domain;


import javax.persistence.*;
import java.util.*;

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
