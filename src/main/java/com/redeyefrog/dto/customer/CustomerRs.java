package com.redeyefrog.dto.customer;

import com.redeyefrog.dto.BaseRs;
import com.redeyefrog.enums.StatusCode;
import lombok.Data;

@Data
public class CustomerRs extends BaseRs {

    public CustomerRs(StatusCode statusCode) {
        super(statusCode);
    }

}
