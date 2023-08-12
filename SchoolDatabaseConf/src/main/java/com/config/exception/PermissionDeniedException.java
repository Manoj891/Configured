package com.config.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PermissionDeniedException extends RuntimeException {
    private String errorMessage = "You do not have permission to access this feature.";
    private String fieldName = "You do not have permission to access this feature.";

    public PermissionDeniedException() {
        super("You do not have permission to access this feature.", null, false, false);
    }

    public PermissionDeniedException(String msg) {
        super("You do not have permission to access this feature." + msg, null, false, false);
        errorMessage = "You do not have permission to access this feature." + msg;
        fieldName = "You do not have permission to access this feature." + msg;
    }
}
