package com.hadit1993.admin.dashboard.spring.utils.errors;

import org.springframework.http.HttpStatus;

public final class BadRequestException extends HttpException {
    public BadRequestException(String message, Object data) {
        super(message, HttpStatus.BAD_REQUEST, data);
    }
}
