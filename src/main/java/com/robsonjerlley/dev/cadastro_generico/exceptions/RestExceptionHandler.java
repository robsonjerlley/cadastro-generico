package com.robsonjerlley.dev.cadastro_generico.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler {

    public ResponseEntity<Object> handlerResourceNotFoundException(
            ResourceNotFoundException ex, HttpServletRequest request){

        Map<String, Object> body = new LinkedHashMap<>();
           body.put("timestamp", LocalDate.now());
           body.put("status", HttpStatus.NOT_FOUND.value());
           body.put("erro:", "Recurso não encontrado.");
           body.put("message", ex.getMessage());
           body.put("path", request.getRequestURI());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> handlerBusinessRuleException(
            BusinessRuleException ex, HttpServletRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.CONFLICT);
        body.put("erro:", "Gera conflito em uma regra de negócio.");
        body.put("message", ex.getMessage());
        body.put("path", request.getRequestURI());

        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }


    public ResponseEntity<Object> handlerGenericException(
            GenericException ex, HttpServletRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        body.put("erro:", "INTERNAL_SERVER_ERROR.");
        body.put("message", ex.getMessage());
        body.put("path", request.getRequestURI());

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);

    }


}
