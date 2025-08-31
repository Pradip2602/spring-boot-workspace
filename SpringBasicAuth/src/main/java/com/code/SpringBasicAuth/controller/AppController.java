package com.code.SpringBasicAuth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AppController provides basic endpoints for the application.
 * - Acts as a REST controller handling HTTP requests.
 * - Currently includes a simple health check endpoint.
 */
@RestController // Marks this class as a REST controller
@RequestMapping("/api") // Base path for all endpoints in this controller
public class AppController {

    /**
     * Health check endpoint.
     * - URL: GET /api/healthCheck
     * - Returns a simple response indicating the app is running.
     *
     * @return ResponseEntity with message "App Status : Healthy"
     */
    @GetMapping("/healthCheck")
    public ResponseEntity<String> AppHealthCheck() {
        // Return HTTP 200 OK with a simple status message
        return ResponseEntity.ok("App Status : Healthy");
    }
}
