package com.redeyefrog.handler;

import com.redeyefrog.dto.BaseRs;
import com.redeyefrog.enums.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseRs onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<String> errorMessages = e.getBindingResult().getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList());

        String message = StringUtils.join(errorMessages, ",");

        return new BaseRs(StatusCode.INVALID.getCode(), message);
    }

    @ExceptionHandler(Exception.class)
    public BaseRs onException(Exception e) {
        log.error(e.getMessage(), e);

        return new BaseRs(StatusCode.UNKNOWN);
    }

}
