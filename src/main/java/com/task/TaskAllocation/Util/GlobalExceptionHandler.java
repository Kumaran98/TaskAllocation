package com.task.TaskAllocation.Util;

import com.task.TaskAllocation.Enum.RestApiResponseStatus;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ResponseWrapper<?>> handleEntityNotFoundExceptions(EntityNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseWrapper<>(RestApiResponseStatus.BAD_REQUEST.getStatusCode(),
                        ValidationMessages.EntityNotFound, null));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseWrapper<?>> handleValidationExceptions(MethodArgumentNotValidException e) {
        StringBuilder errorMessage = new StringBuilder();
        e.getBindingResult().getFieldErrors().forEach(error -> {
            errorMessage.append(error.getDefaultMessage()).append(" ");
        });
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseWrapper<>(RestApiResponseStatus.BAD_REQUEST.getStatusCode(),
                        ValidationMessages.MethodArgumentNotValid, errorMessage.toString()));
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ResponseWrapper<?>> handleValidationExceptions(DataIntegrityViolationException e) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseWrapper<>(RestApiResponseStatus.BAD_REQUEST.getStatusCode(),
                        ValidationMessages.DataIntegrityViolations, null));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ResponseWrapper<?>> handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException e) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseWrapper<>(RestApiResponseStatus.BAD_REQUEST.getStatusCode(),
                        ValidationMessages.WRONG_API_CALL, null));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ResponseWrapper<?>> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException e) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseWrapper<>(RestApiResponseStatus.BAD_REQUEST.getStatusCode()
                        , ValidationMessages.MISMATCH_INPUT , null));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseWrapper<?>> handleOtherExceptions(Exception e) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<>(
                RestApiResponseStatus.INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage(), e.toString()));
    }
}
