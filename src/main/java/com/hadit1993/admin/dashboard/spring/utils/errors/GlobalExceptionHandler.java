package com.hadit1993.admin.dashboard.spring.utils.errors;


import com.hadit1993.admin.dashboard.spring.data.dtos.BaseResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<BaseResponse<Object>> handleHttpException(HttpException e) {
        return new BaseResponse<>(e.getData(), false, e.getMessage()).convertToResponse(e.getStatusCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<Object>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        String message = !errors.isEmpty() ? "some inputs are invalid" : ex.getMessage();
        BaseResponse<Object> response = new BaseResponse<>(errors, false, message);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<BaseResponse<Object>> handleValidationException(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(constraintViolation -> {
            String[] propertyPath = constraintViolation.getPropertyPath().toString().split("\\.");
            errors.put(propertyPath[propertyPath.length - 1], constraintViolation.getMessage());

        });

        return new BaseResponse<Object>(errors,false ,"some inputs are invalid").convertToResponse(HttpStatus.BAD_REQUEST);
    }

}
