package com.example.algosolved.common.swagger;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI(@Value("${springdoc.version}") String springdocVersion) {
        Info info = new Info()
                .title("AlgoSolved")
                .version(springdocVersion)
                .description("API Docs");

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}