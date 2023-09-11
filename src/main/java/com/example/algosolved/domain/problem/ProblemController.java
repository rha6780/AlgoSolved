package com.example.algosolved.domain.problem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProblemController {
    @Autowired
    private ProblemRepository repository;

    @GetMapping("/")
    public String getIndexView() {
        return "index";
    }
}
