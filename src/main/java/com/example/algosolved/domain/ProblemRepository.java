package com.example.algosolved.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProblemRepository extends CrudRepository<Problem, Long> {
    List<Problem> findById(long id);

    List<Problem> findByList();
}
