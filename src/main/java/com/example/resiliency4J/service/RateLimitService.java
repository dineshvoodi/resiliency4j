package com.example.resiliency4J.service;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RateLimitService {

    @RateLimiter(name = "rateLimiterCallService", fallbackMethod = "fallbackMethod")
    public String callService() {
        return "Success";
    }

    public String fallbackMethod(Exception ex) {
        log.info("Too Many Requests");
        return "Too Many Requests";
    }

}
