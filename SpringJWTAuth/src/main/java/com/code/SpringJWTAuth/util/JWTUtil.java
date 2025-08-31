package com.code.SpringJWTAuth.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JWTUtil {

    private final String secret = "Wg1tXn4zQ8ZtR9hHk7bJ3pN1vVqLxY5sT2aDqMfUcVo=";
    private final SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
    private final long EXPIRATION_TME = 1000 * 60 * 60; // 1Hour

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}
