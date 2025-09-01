package com.code.SpringJWTAuth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppController {
    @GetMapping("/healthCheck")
    public ResponseEntity<String> appHealthCheck() {
        return ResponseEntity.ok("App Health status : Healthy");
    }
}
