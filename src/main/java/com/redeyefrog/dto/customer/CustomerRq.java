package com.redeyefrog.dto.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.redeyefrog.dto.BaseRq;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class CustomerRq extends BaseRq {

    @NotBlank(message = "ID is Blank")
    @Schema(name = "ID", description = "Customer Id", example = "00000000", required = true)
    @JsonProperty("ID")
    private String id;

    @Schema(name = "NAME", description = "Customer Name", example = "RedEyeFrog")
    @JsonProperty("NAME")
    private String name;

    @Email(regexp = "^([A-Za-z0-9+_.-]+@(.+))?$", message = "EMAIL is not Valid") // allow blank
//    @Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "EMAIL is not Valid")
    @Schema(name = "EMAIL", description = "Customer E-Mail", example = "red.eye@frog.com")
    @JsonProperty("EMAIL")
    private String email;

}
