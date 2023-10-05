package com.example.algosolved.domain.user.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpDto {
    private String name;
    private String email;
    private String password;


    public SignUpDto() {}
}
