package com.example.simple_http_api.controller;

import com.example.simple_http_api.service.HelloWorldService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloWorldController.class)
public class HelloWorldTestController {

    @Autowired
    public MockMvc mockMvc;

    @MockitoBean
    private HelloWorldService helloWorldService;

    @Test
    public void shouldReturnGreetingStartingWithA() throws Exception {
        when(helloWorldService.generateGreetingResult("alice"))
                .thenReturn("Hello Alice");
        mockMvc.perform(get("/hello-world").param("name", "alice"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message")
                .value("Hello Alice"));
    }

    @Test
    public void shouldReturnGreetingStartingWithM() throws Exception {
        when(helloWorldService.generateGreetingResult("mike"))
                .thenReturn("Hello Mike");
        mockMvc.perform(get("/hello-world").param("name", "mike"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message")
                        .value("Hello Mike"));
    }

    @Test
    void shouldReturnErrorForNameStartingWithN() throws Exception {
        when(helloWorldService.generateGreetingResult("niki"))
                .thenReturn("Invalid Input");
        mockMvc.perform(get("/hello-world").param("name", "niki"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error")
                        .value("Invalid Input"));
    }

    @Test
    void shouldReturnErrorForNameStartingWithZ() throws Exception {
        when(helloWorldService.generateGreetingResult("zara"))
                .thenReturn("Invalid Input");
        mockMvc.perform(get("/hello-world").param("name", "zara"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error")
                        .value("Invalid Input"));
    }

    @Test
    void shouldReturnErrorWhenNameIsMissing() throws Exception {
        when(helloWorldService.generateGreetingResult(null))
                .thenReturn("Invalid Input");
        mockMvc.perform(get("/hello-world"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error")
                        .value("Invalid Input"));
    }

    @Test
    void shouldReturnErrorWhenNameIsEmpty() throws Exception {
        when(helloWorldService.generateGreetingResult(""))
                .thenReturn("Invalid Input");
        mockMvc.perform(get("/hello-world").param("name", ""))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error")
                        .value("Invalid Input"));
    }

    @Test
    void shouldReturnErrorWhenNameContainsOnlyWhitespace() throws Exception {
        when(helloWorldService.generateGreetingResult("    "))
                .thenReturn("Invalid Input");
        mockMvc.perform(get("/hello-world").param("name", "    "))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error")
                        .value("Invalid Input"));
    }

    @Test
    void shouldReturnErrorWhenNameWithWhitespace() throws Exception {
        when(helloWorldService.generateGreetingResult(" ben "))
                .thenReturn("Hello Ben");
        mockMvc.perform(get("/hello-world").param("name", " ben "))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message")
                        .value("Hello Ben"));
    }
}
