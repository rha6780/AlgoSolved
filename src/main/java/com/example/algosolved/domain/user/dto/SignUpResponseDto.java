package com.example.algosolved.domain.user.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignUpResponseDto {

    private Boolean isValid;
    private String field;

    public SignUpResponseDto(Boolean isValid, String field) {
        this.isValid = isValid;
        this.field = field;
    }

}
