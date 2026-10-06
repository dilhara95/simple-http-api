package com.example.simple_http_api.controller;


import com.example.simple_http_api.dto.ApiResponse;
import com.example.simple_http_api.dto.ErrorResponse;
import com.example.simple_http_api.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private static final String INVALID_INPUT = "Invalid Input";

    private final HelloWorldService service;

    public HelloWorldController(HelloWorldService service) {
        this.service = service;
    }

    @GetMapping("/hello-world")
    public ResponseEntity<?> getHelloWorldResult(@RequestParam(required = false) String name) {
        String message = service.generateGreetingResult(name);
        if (INVALID_INPUT.equals(message)) {
            return ResponseEntity.badRequest().body(new ErrorResponse(INVALID_INPUT));
        }
        return ResponseEntity.ok().body(new ApiResponse(message));
    }
}
