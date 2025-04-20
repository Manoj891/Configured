package com.example.gateway.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private final String message;
    private final int status;

    public CustomException(int status, String message) {
        super(message, null, false, false);
        this.status = status;
        this.message = message;
    }

}
