package com.example.algosolved;

import com.example.algosolved.domain.problem.ProblemRepository;
import com.example.algosolved.domain.solve.SolveRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
@EnableJpaAuditing
public class AlgosolvedApplication {

	private static final Logger logger = LoggerFactory.getLogger(AlgosolvedApplication.class);

	@Autowired
	private ProblemRepository problemRepository;
	private SolveRepository solveRepository;

	public static void main(String[] args) {
		SpringApplication.run(AlgosolvedApplication.class, args);
	}

}
