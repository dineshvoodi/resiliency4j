package com.example.resiliency4J.controller;


import com.example.resiliency4J.service.CircuitBreakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/circuitBreaker")
public class CircuitBreakerController {

    @Autowired
    private CircuitBreakerService circuitBreakerService;

    @GetMapping("/test")
    public String circuitBreaker() {
        return circuitBreakerService.callService();
    }

}
