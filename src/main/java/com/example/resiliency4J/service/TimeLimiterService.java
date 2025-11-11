package com.example.resiliency4J.service;

import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class TimeLimiterService {

    @TimeLimiter(name = "timeLimiterCallService", fallbackMethod = "fallbackMethod")
    public CompletableFuture<String> callService() throws InterruptedException {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Success";
        }
        );
    }

    private static String response() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Success";
    }

    public CompletableFuture<String> fallbackMethod(Exception ex) {
        return CompletableFuture.completedFuture("Fallback");
    }

}
