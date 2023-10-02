package com.example.algosolved.domain.problem.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CreateProblemRequest {
    @NotEmpty
    private String title;

    @NotEmpty
    private String content;

    @NotEmpty
    private Long number;
}
