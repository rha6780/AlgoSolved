package com.example.algosolved.domain.problem;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProblemRepository extends JpaRepository<Problem, Long> {
    Optional<Problem> findByNumber(long number);
    Optional<Problem> findById(long id);
}
