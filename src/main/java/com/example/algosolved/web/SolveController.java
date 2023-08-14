package com.example.algosolved.web;

import com.example.algosolved.domain.SolveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SolveController {
    @Autowired
    private SolveRepository repository;

}
