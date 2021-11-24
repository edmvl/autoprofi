package ru.zhendozzz.autoprofi.autoprofi.exceptions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    ResponseEntity<ApiError> handleIdNotFound(HttpServletRequest request, HttpServletResponse response, EntityNotFoundException ex) {
        ApiError apiError = new ApiError("entity not found exception", ex.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NumberFormatException.class)
    ResponseEntity<ApiError> handleIdNotFound(HttpServletRequest request, HttpServletResponse response, NumberFormatException ex) {
        ApiError apiError = new ApiError("Converting error", ex.toString());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}
