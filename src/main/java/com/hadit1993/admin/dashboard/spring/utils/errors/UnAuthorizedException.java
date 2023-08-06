package com.hadit1993.admin.dashboard.spring.utils.errors;

import org.springframework.http.HttpStatus;

public final class UnAuthorizedException extends HttpException {
    public UnAuthorizedException(String message) {
        super(message, HttpStatus.UNAUTHORIZED, null);
    }
}
