package com.code.SpringJWTAuth.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

/**
 * Utility class for generating, parsing, and validating JWT tokens.
 */
@Component
public class JWTUtil {

    // Secret key used for signing the JWT (must be kept safe)
    private final String secret = "Wg1tXn4zQ8ZtR9hHk7bJ3pN1vVqLxY5sT2aDqMfUcVo=";

    // Converts the secret into a SecretKey for signing
    private final SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());

    // Token expiration time in milliseconds (1 hour)
    private final long EXPIRATION_TME = 1000 * 60 * 60;

    /**
     * Generates a JWT token for the given username.
     *
     * @param username The username to include in the token
     * @return JWT token as a String
     */
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // Set the username as the subject
                .setIssuedAt(new Date()) // Set token creation time
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TME)) // Set expiration
                .signWith(key, SignatureAlgorithm.HS256) // Sign with secret key using HS256
                .compact();
    }

    /**
     * Extracts the username from a JWT token.
     *
     * @param token JWT token
     * @return username present in the token
     */
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    /**
     * Extracts all claims (payload) from the JWT token.
     *
     * @param token JWT token
     * @return Claims object containing token information
     */
    private Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * Validates the JWT token.
     * Checks if the username matches and the token is not expired.
     *
     * @param username Username to match
     * @param userDetails UserDetails object of the user
     * @param token JWT token to validate
     * @return true if valid, false otherwise
     */
    public boolean validateToken(String username, UserDetails userDetails, String token) {
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * Checks if the JWT token is expired.
     *
     * @param token JWT token
     * @return true if expired, false otherwise
     */
    public boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }
}
