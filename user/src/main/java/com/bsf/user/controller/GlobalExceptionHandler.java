package com.bsf.user.controller;

import com.bsf.user.exceptions.EmailExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmailExistsException.class)
    public ResponseEntity<ErrorResponse> handleAlReadyExistsException(Exception ex) {
        ErrorResponse error = ErrorResponse.create(ex, HttpStatus.CONFLICT, ex.getMessage());
        return ResponseEntity.status(409).body(error);
    }
}