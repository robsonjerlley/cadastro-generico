package com.robsonjerlley.dev.cadastro_generico.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@Getter
public class BusinessRuleException extends RuntimeException {

    private final HttpStatus status;
    public BusinessRuleException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }


    public BusinessRuleException(String message) {
        this(message, HttpStatus.CONFLICT);
    }

}
