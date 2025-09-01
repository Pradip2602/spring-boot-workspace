package com.code.SpringJWTAuth.filter;

import com.code.SpringJWTAuth.service.CustomUserDetailsService;
import com.code.SpringJWTAuth.util.JWTUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * JWT Authentication Filter that runs once per request.
 * Responsible for:
 * - Extracting JWT token from the Authorization header
 * - Validating the token
 * - Setting the authentication in Spring Security context if valid
 */
@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    JWTUtil jwtUtil; // Utility class for extracting and validating JWT

    @Autowired
    CustomUserDetailsService customUserDetailsService; // Loads user details from database

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // Get Authorization header from request
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        // Check if header is present and starts with "Bearer "
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7); // Remove "Bearer " prefix to get token
            username = jwtUtil.extractUsername(token); // Extract username from JWT
        }

        // If username is extracted and user is not already authenticated
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            // Load user details from database
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

            // Validate JWT token
            if (jwtUtil.validateToken(username, userDetails, token)) {
                // Create authentication token for Spring Security context
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                // Set additional details (like IP address, session ID, etc.)
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Set authentication in Spring Security context
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        // Continue filter chain
        filterChain.doFilter(request, response);
    }
}
