package com.hadit1993.admin.dashboard.spring.utils.errors;

import org.springframework.http.HttpStatus;

public final class NotFoundException extends HttpException {
    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND, null);
    }
}
