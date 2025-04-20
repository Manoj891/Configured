package com.example.gateway.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {
    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<String> handleUnauthorized(CustomException e) {
        log.error(e.getMessage());
        return ResponseEntity.status(e.getStatus()).body(e.getMessage());
    }


}
