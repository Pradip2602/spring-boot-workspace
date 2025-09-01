package com.code.SpringJWTAuth.config;

import com.code.SpringJWTAuth.filter.JwtAuthFilter;
import com.code.SpringJWTAuth.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity  // Enables Spring Security's web security support
public class SecurityConfig {

    @Autowired
    JwtAuthFilter jwtAuthFilter;  // Custom JWT authentication filter

    /**
     * Configures HTTP security for the application.
     * - Disables CSRF protection since JWT is stateless
     * - Allows H2 console to be accessed in browser
     * - Sets which endpoints are publicly accessible and which require authentication
     * - Adds JWT filter before Spring Security's UsernamePasswordAuthenticationFilter
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf -> csrf.disable())  // Disable CSRF for stateless JWT-based security
                .headers(headers -> headers.frameOptions(frame -> frame.disable())) // Allow H2 console in browser
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**", "/h2-console/**", "/api/healthCheck").permitAll() // Public endpoints
                        .anyRequest().authenticated() // All other endpoints require authentication
                );

        // Add JWT filter before UsernamePasswordAuthenticationFilter
        httpSecurity.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

    /**
     * Provides the custom UserDetailsService implementation.
     * This service loads user-specific data (like username, password, roles) for authentication.
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    /**
     * Provides a PasswordEncoder for encoding and verifying passwords.
     * BCrypt is used here for hashing passwords securely.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configures the AuthenticationManager, which is responsible for authenticating users.
     * - Uses DaoAuthenticationProvider with the custom UserDetailsService
     * - PasswordEncoder is applied to validate the hashed passwords
     */
    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService); // Set custom user details service
        authenticationProvider.setPasswordEncoder(passwordEncoder); // Set password encoder
        return new ProviderManager(authenticationProvider); // Return AuthenticationManager with provider
    }
}
