package com.example.algosolved.domain.problem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProblemController {
    @Autowired
    private ProblemRepository repository;

    @RequestMapping("/api/v1/problem")
    public Iterable<Problem> getProblem(@RequestParam("id") long id) {
        return repository.findById(id);
    }
}
