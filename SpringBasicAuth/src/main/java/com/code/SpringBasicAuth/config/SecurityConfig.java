package com.code.SpringBasicAuth.config;

import com.code.SpringBasicAuth.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; // Use @Configuration instead of @Component for clarity
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * SecurityConfig sets up Spring Security for the application.
 * - Protects all endpoints except the H2 console.
 * - Uses HTTP Basic Authentication.
 * - Configures custom user authentication with BCrypt password encoding.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configures HTTP security for the application.
     * - Allows unrestricted access to the H2 console (for development).
     * - Requires authentication for all other endpoints.
     * - Disables CSRF and frame options so H2 console can load in browser.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth ->
                        auth
                                // Whitelist H2 console endpoint (no authentication required)
                                .requestMatchers("/h2-console/**").permitAll()
                                // All other requests must be authenticated
                                .anyRequest().authenticated()
                )
                // Use HTTP Basic authentication (username/password in browser prompt)
                .httpBasic(withDefaults())
                // Disable CSRF protection since H2 console does not support CSRF tokens
                .csrf(csrf -> csrf.disable())
                // Allow H2 console to be rendered inside frames
                .headers(headers -> headers.frameOptions(frame -> frame.disable()));
        return http.build();
    }

    /**
     * Provides a custom UserDetailsService that loads user details from the database.
     * This service is used by Spring Security to authenticate and authorize users.
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    /**
     * Configures password encoding using BCrypt.
     * All passwords in the database must be stored in BCrypt format.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Creates an AuthenticationManager that uses a DaoAuthenticationProvider.
     * - DaoAuthenticationProvider checks username/password using UserDetailsService.
     * - Passwords are validated using the configured PasswordEncoder.
     */
    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService,
                                                       PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService); // load user data from DB
        authenticationProvider.setPasswordEncoder(passwordEncoder);       // verify password with BCrypt
        return new ProviderManager(authenticationProvider);
    }
}
