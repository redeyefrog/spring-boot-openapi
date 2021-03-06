package com.redeyefrog.config;

import com.redeyefrog.controller.ApiController;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

//@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi helloOpenApi() {
        return GroupedOpenApi.builder()
                .group("HelloWorld")
                .packagesToScan("com.redeyefrog.controller")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public GroupedOpenApi apiOpenApi() {
        return GroupedOpenApi.builder()
                .group("API")
                .packagesToScan(ApiController.class.getPackageName())
                .pathsToMatch("/api/**")
                .build();
    }

    @Bean
    public OpenAPI openApi() {
        Contact contact = new Contact()
                .name("RedEyeFrog")
                .url("https://github.com/redeyefrog")
                .email("redeyefrog@contact.com");

        Info info = new Info().title("Hello Red Eye Frog")
                .description("This is Open API")
                .version("v1.0")
                .contact(contact);

        ExternalDocumentation externalDocs = new ExternalDocumentation();

        return new OpenAPI()
                .info(info)
                .externalDocs(externalDocs);
    }

}
