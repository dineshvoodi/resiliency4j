package com.example.resiliency4J.service;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RetryService {

    @Retry(name = "retryCallService", fallbackMethod = "fallbackMethod")
    public String callService() {
        if(Math.random() < 0.5) {
            log.info("Failed");
            throw new ArithmeticException();
        }
        return "Success";
    }

    public String fallbackMethod(Exception ex) {
        return "Fallback";
    }

}
