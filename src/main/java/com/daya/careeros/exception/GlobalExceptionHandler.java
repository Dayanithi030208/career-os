package com.daya.careeros.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateEmailException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> handleDuplicateEmail(
            DuplicateEmailException exception) {

        return Map.of(
                "error", exception.getMessage());
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Map<String, String> handleInvalidCredentials(
            InvalidCredentialsException exception) {

        return Map.of(
                "error", exception.getMessage());
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> handleConflict(
            ConflictException exception) {

        return Map.of(
                "error", exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleValidation(
            MethodArgumentNotValidException exception) {

        Map<String, String> fields = new java.util.HashMap<>();

        exception.getBindingResult()
                .getFieldErrors()
                .forEach(error -> fields.put(
                        error.getField(),
                        error.getDefaultMessage()));

        return Map.of(
                "error", "Validation failed",
                "fields", fields);
    }
}