package com.example.algosolved.repository;

import com.example.algosolved.model.Problem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProblemRepository extends CrudRepository<Problem, Long> {
    List<Problem> findById(long id);

//    Page<Problem> findByOrderByIdDesc(Pageable pageable);
}
