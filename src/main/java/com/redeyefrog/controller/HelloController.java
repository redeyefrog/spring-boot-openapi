package com.redeyefrog.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@OpenAPIDefinition(info = @Info(title = "Hello Red Eye Frog", description = "This is OpenAPI", version = "v1.0"))
@RestController
public class HelloController {

    @Operation(operationId = "sayHello", summary = "Say Hello", description = "Say Hello to Someone",
    parameters = { @Parameter(name = "name", description = "Someone's Name", required = true) },
    responses = { @ApiResponse(responseCode = "200", description = "Success"),
                  @ApiResponse(responseCode = "400", description = "Invalid"),
                  @ApiResponse(responseCode = "404", description = "Not Found") })
    @PostMapping("/say")
    public String sayHello(@RequestParam String name) {
        return MessageFormat.format("Hello {0}", name);
    }

}
