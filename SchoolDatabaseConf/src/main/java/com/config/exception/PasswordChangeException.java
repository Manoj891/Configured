package com.config.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PasswordChangeException extends RuntimeException {
    private String errorMessage = "You must be need change password.";
    private String fieldName = "You must be need change password.";

    public PasswordChangeException() {
        super("You must be need change password.", null, false, false);
    }
}
