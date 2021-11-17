package br.com.diego.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition (info  =
@Info (title = "Job Service API",
        version = "V1",
        description = "Documentation of Job Service API"))
public class OpenApiConfiguration {

    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .components(new Components())
                .info(
                        new io.swagger.v3.oas.models.info.Info()
                        .title("Job Service API")
                        .version("v1")
                        .license(new License()
                        .name("Apache 2.0")
                        .url("http://springdoc.org"))
                );
    }

}