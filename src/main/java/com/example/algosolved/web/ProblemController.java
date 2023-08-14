package com.example.algosolved.web;

import com.example.algosolved.domain.Problem;
import com.example.algosolved.domain.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProblemController {
    @Autowired
    private ProblemRepository repository;

    @RequestMapping(value="/problems")
    public Iterable<Problem> getProblems() {
        return repository.findAll();
    }
}
