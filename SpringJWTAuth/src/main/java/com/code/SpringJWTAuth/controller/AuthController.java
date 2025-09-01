package com.code.SpringJWTAuth.controller;

import com.code.SpringJWTAuth.dto.AuthRequest;
import com.code.SpringJWTAuth.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")  // Base URL for all endpoints in this controller
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager; // Spring Security AuthenticationManager to authenticate users

    @Autowired
    JWTUtil jwtUtil; // Utility class for generating and validating JWT tokens

    /**
     * Endpoint to authenticate user and generate JWT token.
     * URL: POST /api/auth
     *
     * @param authRequest Contains username and password sent in request body
     * @return JWT token if authentication is successful
     */
    @PostMapping("/auth")
    public String genrateToken(@RequestBody AuthRequest authRequest) {
        try {
            // Authenticate the user using username and password
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getUsername(),
                            authRequest.getPassword()
                    )
            );

            // Generate JWT token for authenticated user
            return jwtUtil.generateToken(authRequest.getUsername());
        } catch (Exception e) {
            // Throw runtime exception if authentication fails
            throw new RuntimeException("Invalid username or password", e);
        }
    }
}
