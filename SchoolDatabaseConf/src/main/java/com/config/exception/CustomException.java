package com.config.exception;

import lombok.Data;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Objects;

@Data
public class CustomException extends RuntimeException {
    private String errorMessage;
    private String fieldName;
    private String message;
    public CustomException() {
    }

    public CustomException(String errorMessage) {
        super(errorMessage, null, false, false);
        this.errorMessage = errorMessage;
        this.fieldName = errorMessage;
        this.message=errorMessage;
    }

    public CustomException(String message,  String fieldName) {
        super(message, null, false, false);
        this.errorMessage = message;
        this.fieldName = fieldName;
        this.message=message;
    }




    public CustomException(String errorMessage, DataIntegrityViolationException e) {
        super(errorMessage, null, false, false);
        this.fieldName = e.getRootCause().getMessage();
        if (fieldName.contains("Detail:")) {
            fieldName = fieldName.substring(fieldName.indexOf("Detail:") + 7);
        }
        this.errorMessage = fieldName;
        this.message=errorMessage;
    }

    public CustomException(DataIntegrityViolationException e) {
        super(e.getMessage(), null, false, false);
        this.fieldName = e.getRootCause().getMessage();
        if (fieldName.contains("Detail:")) {
            fieldName = fieldName.substring(fieldName.indexOf("Detail:") + 7);
        }
        this.errorMessage = fieldName;
        this.message=errorMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomException that = (CustomException) o;
        return Objects.equals(errorMessage, that.errorMessage) && Objects.equals(fieldName, that.fieldName) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorMessage, fieldName, message);
    }
}
