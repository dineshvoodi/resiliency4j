package com.example.resiliency4J.controller;


import com.example.resiliency4J.service.RetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/retry")
public class RetryController {

    @Autowired
    private RetryService retryService;

    @GetMapping("/test")
    public String retry() {
        return retryService.callService();
    }

}
