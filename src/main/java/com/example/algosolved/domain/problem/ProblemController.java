package com.example.algosolved.domain.problem;

import com.example.algosolved.common.dto.RestResponse;
import com.example.algosolved.domain.problem.dto.CreateProblemRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/problem")
public class ProblemController {

    private final  ProblemService problemService;
//    @Autowired
//    public ProblemService problemService;

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
    @GetMapping("/{id}")
    public ResponseEntity<RestResponse> getProblem(@PathVariable Long id) {
        RestResponse<Object> restResponse = new RestResponse<>();
        Optional<Problem> problem = problemService.getProblemById(id);
        restResponse = RestResponse.builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .message("")
                .data(problem)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(restResponse);
    }

    @PostMapping("")
    public ResponseEntity<RestResponse> newProblem(@RequestBody @Valid CreateProblemRequest request) {

        Problem problem = new Problem(request.getTitle(), request.getContent(), request.getNumber());
        RestResponse<Object> restResponse = new RestResponse<>();
        restResponse = RestResponse.builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .message("")
                .data(problem)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(restResponse);
    }

//    @GetMapping("/api/v1/problems")
//    public Iterable<Problem> getProblems() {
//        return repository.findAll();
//    }
}
