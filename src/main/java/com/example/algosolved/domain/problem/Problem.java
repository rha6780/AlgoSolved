package com.example.algosolved.domain.problem;

import com.example.algosolved.domain.solve.Solve;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@Table(name="Problem")
public class Problem {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long number;

    @Column(name="title", nullable = false, length = 512)
    private String title;

    private String content;

    @OneToMany
    @JoinColumn(name="problem_id")
    private Collection<Solve> solves;

    public Problem(){}

    @Builder
    public Problem(String title, String content, long number) {
        super();
        this.title = title;
        this.content = content;
        this.number = number;
    }

    public Collection<Solve> getSoleves() {
        return solves;
    }
}


