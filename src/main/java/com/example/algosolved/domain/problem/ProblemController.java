package com.example.algosolved.domain.problem;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/problem")
public class ProblemController {

    @Autowired
    public ProblemService problemService;

    @Autowired
    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

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
    @GetMapping("/{num}")
    public ResponseEntity<List<Problem>> getProblem(@PathVariable Long num) {
        List<Problem> res = problemService.getProblemByNumber(num);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

//    @PostMapping("")
//    public ResponseEntity<Problem> newProblem(@RequestBody Problem) {
//        Problem problem = new Problem("title", "content", 1);
//        return ResponseEntity.status(HttpStatus.OK).body(problem);
//    }

//    @GetMapping("/api/v1/problems")
//    public Iterable<Problem> getProblems() {
//        return repository.findAll();
//    }
}
