package com.example.simple_http_api.dto;


public class ApiResponse {
    private final String message;

    public ApiResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
