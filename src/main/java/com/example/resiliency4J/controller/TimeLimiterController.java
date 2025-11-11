package com.example.resiliency4J.controller;


import com.example.resiliency4J.service.TimeLimiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/timeLimiter")
public class TimeLimiterController {

    @Autowired
    private TimeLimiterService timeLimiterService;

    @GetMapping("/test")
    public CompletableFuture<String> timeLimiter() throws InterruptedException {
        return timeLimiterService.callService();
    }

}
