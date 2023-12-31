package com.example.algosolved.domain.solve;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SolveRepository extends CrudRepository<Solve, Long> {
    List<Solve> findById(long id);


}
