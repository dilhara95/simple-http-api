package com.example.simple_http_api.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    public String generateGreetingResult(String name) {
        if (name == null || name.isBlank()) {
            return "Invalid Input";
        }
        String lowercaseName = name.trim().toLowerCase();
        char firstLetter = lowercaseName.charAt(0);
        if (!(firstLetter >= 'a'  && firstLetter <= 'm')){
            return "Invalid Input";
        }
        return "Hello " + Character.toUpperCase(firstLetter) + lowercaseName.substring(1);
    }
}
