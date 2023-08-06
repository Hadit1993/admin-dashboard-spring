package com.hadit1993.admin.dashboard.spring.data.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder

public class BaseResponse<T> {

    @Builder.Default
    private T data = null;
    @Builder.Default
    private boolean success = true;
    @Builder.Default
    private String message = "The operation was successful";

    public ResponseEntity<BaseResponse<T>> convertToResponse() {
        return ResponseEntity.ok(this);
    }
    public ResponseEntity<BaseResponse<T>> convertToResponse(HttpStatus status) {
        return new ResponseEntity<>(this, status);
    }
}


