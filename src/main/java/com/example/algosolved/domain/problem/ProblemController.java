package com.example.algosolved.domain.problem;

import com.example.algosolved.domain.problem.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProblemController {
    @Autowired
    private ProblemRepository repository;

//    @RequestMapping(value="/problems")
//    public Page<Problem> findProblems(int page, int size) {
//        PageRequest pageRequest = PageRequest.of(page, size);
//        return repository.findByOrderByIdDesc((Pageable) pageRequest);
//    }
}