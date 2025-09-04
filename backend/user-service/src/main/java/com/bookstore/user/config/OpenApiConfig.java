package com.bookstore.user.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI secureOpenAPI() {
        return new OpenAPI()
            .info(new Info().title("User Service API").version("1.0.0"))
            .components(new io.swagger.v3.oas.models.Components()
                .addSecuritySchemes("bearer-jwt",
                    new io.swagger.v3.oas.models.security.SecurityScheme()
                        .type(io.swagger.v3.oas.models.security.SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")))
            .addSecurityItem(new io.swagger.v3.oas.models.security.SecurityRequirement().addList("bearer-jwt"));
    }

}
