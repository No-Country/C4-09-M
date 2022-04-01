package com.ecommerce.changuito.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        final List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        final List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();

        StringBuilder errors = new StringBuilder();

        for (FieldError fieldError : fieldErrors) {
            errors
                    .append(fieldError.getField())
                    .append(": ")
                    .append(fieldError.getDefaultMessage())
                    .append("\n");
        }

        for (ObjectError globalError : globalErrors) {
            errors
                    .append(globalError.getObjectName())
                    .append(": ")
                    .append(globalError.getDefaultMessage())
                    .append("\n");
        }

        return new ResponseEntity<>(errors.toString(), headers, status);
    }

}
