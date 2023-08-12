package com.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    private final static String MODULE_NAME = "Back Office Support Management System";
    private final static String SCHEME_NAME = "JWT_Token";
    private final static String BEARER = "Bearer";
    private final static String JWT = "JWT";
    private final static String API_VERSION = "1.0";
    public final static String AUTHENTICATED = "Authenticated";
    private final static String PACKAGES_TO_SCAN = "com.controller.rest";
    private final static String PATHS_TO_MATCH = "/api/**";

    @Bean
    public GroupedOpenApi authenticatedApi() {
        return GroupedOpenApi.builder()
                .group(AUTHENTICATED)
                .packagesToScan(PACKAGES_TO_SCAN)
                .pathsToMatch(PATHS_TO_MATCH)
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(SCHEME_NAME))
                .components(
                        new Components()
                                .addSecuritySchemes(SCHEME_NAME,
                                        new SecurityScheme()
                                                .name(SCHEME_NAME)
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme(BEARER)
                                                .bearerFormat(JWT)
                                )
                ).info(new Info().title(MODULE_NAME).version(API_VERSION));
    }


}
