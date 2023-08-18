package com.example.algosolved.repository;

import com.example.algosolved.model.Solve;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SolveRepository extends CrudRepository<Solve, Long> {
    List<Solve> findById(long id);


}
