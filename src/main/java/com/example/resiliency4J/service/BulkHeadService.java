package com.example.resiliency4J.service;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BulkHeadService {

    @Bulkhead(name = "bulkHeadCallService", fallbackMethod = "bulkHeadFallbackMethod")
    public String callService() throws InterruptedException {
        Thread.sleep(5000);
        return "Success";
    }

    public String bulkHeadFallbackMethod(Exception ex) {
        return "Fallback";
    }

}
