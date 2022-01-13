package com.redeyefrog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.redeyefrog.enums.StatusCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseRs {

    @Schema(name = "RETURN_CODE", description = "RETURN CODE")
    @JsonProperty("RETURN_CODE")
    private String returnCode;

    @Schema(name = "RETURN_DESC", description = "RETURN DESC")
    @JsonProperty("RETURN_DESC")
    private String returnDesc;

    public BaseRs(StatusCode statusCode) {
        this.returnCode = statusCode.getCode();
        this.returnDesc = statusCode.getDesc();
    }

}
