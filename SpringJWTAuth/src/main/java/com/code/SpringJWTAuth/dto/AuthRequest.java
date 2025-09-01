package com.code.SpringJWTAuth.dto;

/**
 * Data Transfer Object (DTO) for authentication requests.
 * This class is used to receive username and password from the client
 * when requesting a JWT token.
 */
public class AuthRequest {

    // Username sent by the client
    private String username;

    // Password sent by the client
    private String password;

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }
}
