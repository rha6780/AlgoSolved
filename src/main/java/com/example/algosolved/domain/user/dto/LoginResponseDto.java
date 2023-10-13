package com.example.algosolved.domain.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponseDto {
    private Boolean isValid;
    private String field;

}
