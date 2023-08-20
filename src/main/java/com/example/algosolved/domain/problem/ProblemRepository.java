package com.example.algosolved.domain.problem;

import com.example.algosolved.domain.problem.Problem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProblemRepository extends CrudRepository<Problem, Long> {
    List<Problem> findById(long id);

//    Page<Problem> findByOrderByIdDesc(Pageable pageable);
}
