package com.redeyefrog.controller;

import com.redeyefrog.dto.customer.CustomerRq;
import com.redeyefrog.dto.customer.CustomerRs;
import com.redeyefrog.enums.StatusCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequestMapping("/api")
@RestController
public class ApiController {

    @Operation(operationId = "customer", summary = "Send Customer Info", description = "Send Customer Info and Do Something",
            responses = { @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "400", description = "Invalid")})
    @PostMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerRs addCustomer(@Valid @RequestBody CustomerRq customerRq) {
        log.info("CustomerRq: {}", customerRq);

        return new CustomerRs(StatusCode.SUCCESS);
    }

}
