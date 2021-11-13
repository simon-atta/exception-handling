package com.dis.exception.handler.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ApiError {

    private String status;
    private String error;
    private String errorCode;
    private String url;
    private String timestamp;

    public ApiError() {
    }

    public ApiError(String status, String timestamp, String error) {
        this.status = status;
        this.timestamp = timestamp;
        this.error = error;
    }

    public ApiError(String status, String error, String errorCode, String url, String timestamp) {
        this.status = status;
        this.error = error;
        this.errorCode = errorCode;
        this.url = url;
        this.timestamp = timestamp;
    }
}
