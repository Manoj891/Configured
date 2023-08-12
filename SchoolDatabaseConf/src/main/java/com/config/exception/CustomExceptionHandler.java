package com.config.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import javax.security.sasl.AuthenticationException;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;


@RestControllerAdvice
public class CustomExceptionHandler {

    private static final Logger LOG = LogManager.getLogger();

    @ExceptionHandler(value = CustomExceptionAndStatus.class)
    public ResponseEntity<CustomException> handleCustomExceptionAndStatus(CustomExceptionAndStatus e) {
        LOG.error(" CustomExceptionAndStatus " + e.getMessage());
        return ResponseEntity.status(e.getStatus()).body(new CustomException(e.getMessage()));
    }

    @ExceptionHandler(value = CustomException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<CustomException> handleException(CustomException e) {
        LOG.error(" CustomException " + e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new CustomException(e.getMessage()));
    }

    @ExceptionHandler(value = PermissionDeniedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<PermissionDeniedException> permissionDeniedExceptionException(PermissionDeniedException e) {
        LOG.error(" PermissionDeniedException " + e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new PermissionDeniedException());
    }

    @ExceptionHandler(value = HttpClientErrorException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<CustomException> handleUnauthorized(HttpClientErrorException e) {
        LOG.error(" HttpClientErrorException " + e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new CustomException(e.getCause().getMessage()));
    }

    @ExceptionHandler(value = AuthenticationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<InvalidAuthenticationException> handleException(AuthenticationException e) {
        LOG.error(" AuthenticationException " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new InvalidAuthenticationException());
    }

    @ExceptionHandler(value = BadCredentialsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CustomException> handleException(BadCredentialsException e) {
        LOG.error(" BadCredentialsException " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomException(e.getCause().getMessage()));
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseStatus(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE)
    public ResponseEntity<CustomException> handleException(AccessDeniedException e) {
        LOG.error(" AccessDeniedException " + e.getMessage());
        return ResponseEntity.status(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE).body(new CustomException(e.getCause().getMessage()));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ResponseEntity<CustomException> handleValidation(MethodArgumentNotValidException e) {
        LOG.error("MethodArgumentNotValidException " + e.getMessage());
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(new CustomException(e.getMessage()));
    }

    @ExceptionHandler(value = InvalidDataAccessApiUsageException.class)
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public ResponseEntity<CustomException> handleException(InvalidDataAccessApiUsageException e) {
        LOG.error("InvalidDataAccessApiUsageException " + e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new CustomException(e.getCause().getMessage()));
    }

    @ExceptionHandler(value = InvocationTargetException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CustomException> invocationTargetException(InvocationTargetException e) {
        LOG.error("InvocationTargetException " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomException(e.getMessage()));
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<CustomException> handleException(DataIntegrityViolationException e) {
        String message = e.getRootCause().getMessage().toLowerCase().replace("`", "");
        if (message.contains("detail:")) {
            message = message.substring(message.indexOf("detail:") + 11);
        } else if (message.contains("foreign key")) {
            if (message.contains(".") && message.contains(",")) {
                message = "This record reference in " + message.substring(message.indexOf(".") + 1, message.indexOf(",")) + ", Can not remove this record.";
            } else if (message.contains(":") && message.contains(",")) {
                message = "This record reference in " + message.substring(message.indexOf(":") + 1, message.indexOf(",")) + ", Can not remove this record.";
            } else {
                message = "This record reference in another place, Can not remove this record.";
            }
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomException(message));
    }

    @ExceptionHandler(value = PasswordChangeException.class)
    @ResponseStatus(HttpStatus.UPGRADE_REQUIRED)
    public ResponseEntity<PasswordChangeException> passwordChangeException(PasswordChangeException e) {
        LOG.error("PasswordChangeException " + e.getMessage());
        return ResponseEntity.status(HttpStatus.UPGRADE_REQUIRED).body(new PasswordChangeException());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<CustomException> handleException(Exception e) {
        LOG.error("Exception " + e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomException(e.getMessage()));
    }


}
