package com.example.resiliency4J.controller;

import com.example.resiliency4J.service.BulkHeadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bulkHead")
@Slf4j
public class BulkHeadController {

    @Autowired
    private BulkHeadService bulkHeadService;

    @GetMapping(value = "/test")
    public String bulkHead() throws InterruptedException {
        return bulkHeadService.callService();
    }

}
