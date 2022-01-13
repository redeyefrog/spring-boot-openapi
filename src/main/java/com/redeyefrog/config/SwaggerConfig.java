package com.redeyefrog.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

//@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi groupedOpenApi() {
        return GroupedOpenApi.builder()
                .group("RedEyeFrog")
                .packagesToScan("com.redeyefrog.controller")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI openApi() {
        Contact contact = new Contact()
                .name("RedEyeFrog")
                .url("https://github.com/redeyefrog")
                .email("redeyefrog@contact.com");

        Info info = new Info().title("Red Eye Frog")
                .description("Description Red Eye Frog")
                .version("v1.0")
                .contact(contact);

        ExternalDocumentation externalDocs = new ExternalDocumentation();

        return new OpenAPI()
                .info(info)
                .externalDocs(externalDocs);
    }

}
