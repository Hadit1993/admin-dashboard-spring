package com.hadit1993.admin.dashboard.spring.utils.errors;


import org.springframework.http.HttpStatus;


public abstract class HttpException extends RuntimeException{
    private final HttpStatus statusCode;
    private final Object data;

    public HttpException(String message, HttpStatus statusCode, Object data) {
        super(message);
        this.statusCode = statusCode;
        this.data = data;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public Object getData() {
        return data;
    }
}

