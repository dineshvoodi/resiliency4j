package com.example.resiliency4J.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@Service
public class CircuitBreakerService {

    @CircuitBreaker(name = "circuitBreakerCallService", fallbackMethod = "fallbackMethod")
    public String callService() {
        if(Math.random() < 0.5) {
            throw new InvalidParameterException();
        }
        return "Success";
    }

    public String fallbackMethod(Exception ex) {
        return "Fallback";
    }

}
