package com.example.algosolved.domain.problem;

import com.example.algosolved.domain.solve.Solve;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="Problem")
public class Problem {
    @Id
    @Column(name="id")
    @GeneratedValue
    private long id;

    private long number;

    @Column(name="title", nullable = false, length = 512)
    private String title;

    private String content;

    @OneToMany
    @JoinColumn(name="problem_id")
    private Collection<Solve> solves;

    public Problem() {}

    public Problem(String title, String content) {
        super();
        this.title = title;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public long getNumber() {return number;}

    public void setNumber(long number) { this.number = number; }

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

    public Collection<Solve> getSoleves() {
        return solves;
    }
}


