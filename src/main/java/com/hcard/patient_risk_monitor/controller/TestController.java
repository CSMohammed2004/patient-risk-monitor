package com.hcard.patient_risk_monitor.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/api/v1/test")
    public Map<String, String> test() {
        return Map.of("message", "Backend is running!");
    }
}
