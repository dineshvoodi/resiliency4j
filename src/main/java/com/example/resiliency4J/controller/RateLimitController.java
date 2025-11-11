package com.example.resiliency4J.controller;


import com.example.resiliency4J.service.RateLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rateLimiter")
public class RateLimitController {

    @Autowired
    private RateLimitService rateLimitService;

    @GetMapping("/test")
    public String rateLimiter() {
        return rateLimitService.callService();
    }

}
