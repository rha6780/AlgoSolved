package com.example.algosolved.domain.problem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProblemService {
    private final ProblemRepository problemRepository;


    @Autowired
    public ProblemService(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    public Long newProblem(Problem problem) {
        problemRepository.save(problem);
        return problem.getId();
    }
}
