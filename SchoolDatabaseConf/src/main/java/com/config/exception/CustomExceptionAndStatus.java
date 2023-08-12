package com.config.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Objects;

@Data
public class CustomExceptionAndStatus extends RuntimeException {
    private String message;
    private String errorMessage;
    private HttpStatus status;

    public CustomExceptionAndStatus(String message, HttpStatus status) {
        super(message, null, false, false);
        this.message = message;
        this.errorMessage = message;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomExceptionAndStatus that = (CustomExceptionAndStatus) o;
        return Objects.equals(message, that.message) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, status);
    }
}
