package com.redeyefrog.controller;

import com.redeyefrog.dto.customer.CustomerRq;
import com.redeyefrog.dto.customer.CustomerRs;
import com.redeyefrog.enums.StatusCode;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@OpenAPIDefinition(info = @Info(title = "Red Eye Frog", description = "This is API", version = "v1.0"))
@RequestMapping("/api")
@RestController
public class ApiController {

    @Operation(operationId = "customer", summary = "Send Customer Info", description = "Send Customer Info and Do Something",
            responses = { @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "400", description = "Invalid")})
    @PostMapping(value = "/customer")
    public CustomerRs addCustomer(@Validated @RequestBody CustomerRq customerRq) {
        log.info("CustomerRq: {}", customerRq);

//        if(result.hasErrors()) {
//            List<String> errors = result.getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList());
//
//            String message = StringUtils.join(errors, ",");
//
//            return new CustomerRs(StatusCode.INVALID.getCode(), message);
//        }

        return new CustomerRs(StatusCode.SUCCESS);
    }

}
