package com.config.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class InvalidAuthenticationException extends RuntimeException {
    private HttpStatus status = HttpStatus.UNAUTHORIZED;
    private String message = "Invalid Authentication Exception";

    public InvalidAuthenticationException() {

    }

}