package com.example.algosolved.domain.solve;

import com.example.algosolved.domain.solve.SolveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SolveController {
    @Autowired
    private SolveRepository repository;

}
