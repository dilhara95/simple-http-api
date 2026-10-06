package com.example.simple_http_api.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorldTestService {

    private final HelloWorldService service = new HelloWorldService();

    @Test
    void shouldReturnGreetingForNameStartingWithA() {
        String result = service.generateGreetingResult("alice");
        assertEquals("Hello Alice", result);
    }

    @Test
    void shouldReturnGreetingForNameStartingWithM() {
        String result = service.generateGreetingResult("mike");
        assertEquals("Hello Mike", result);
    }

    @Test
    void shouldRejectNameStartingWithN() {
        String result = service.generateGreetingResult("nancy");
        assertEquals("Invalid Input", result);
    }

    @Test
    void shouldRejectNameStartingWithZ() {
        String result = service.generateGreetingResult("zara");
        assertEquals("Invalid Input", result);
    }

    @Test
    void shouldRejectWhenNameIsMissing() {
        String result = service.generateGreetingResult(null);
        assertEquals("Invalid Input", result);
    }

    @Test
    void shouldRejectWhenNameIsEmpty() {
        String result = service.generateGreetingResult("");
        assertEquals("Invalid Input", result);
    }

    @Test
    void shouldRejectWhenNameContainsOnlyWhitespace() {
        String result = service.generateGreetingResult("     ");
        assertEquals("Invalid Input", result);
    }

    @Test
    void shouldRejectWhenNameWithWhitespace() {
        String result = service.generateGreetingResult("   ben  ");
        assertEquals("Hello Ben", result);
    }

}
