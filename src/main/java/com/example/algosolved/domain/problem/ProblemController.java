package com.example.algosolved.domain.problem;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProblemController {

    @Autowired
    public ProblemRepository repository;

    @Operation(summary = "get problem", description = "문제 정보 가져오기")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @Parameters({
            @Parameter(name = "id", description = "문제 id", example = "1"),
    })
    @GetMapping("/api/v1/problem")
    public Iterable<Problem> getProblem(@RequestParam("number") long number) {
        return repository.findByNumber(number);
    }

    @GetMapping("/api/v1/problems")
    public Iterable<Problem> getProblems() {
        return repository.findAll();
    }
}
