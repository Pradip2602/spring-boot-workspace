package com.code.SpringJWTAuth.service;

import com.code.SpringJWTAuth.entity.Users;
import com.code.SpringJWTAuth.repository.UserDetailsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Component to initialize a default admin user in the database on application startup.
 * Uses CommandLineRunner to run the logic after the Spring Boot application starts.
 */
@Component
public class AdminUserInitializer {

    /**
     * Creates a default admin user if it does not already exist.
     *
     * @param userDetailsRepository Repository to interact with Users table
     * @param passwordEncoder Encoder to hash the admin password
     * @return CommandLineRunner to run this logic on startup
     */
    @Bean
    public CommandLineRunner createAdminUser(UserDetailsRepository userDetailsRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            try {
                // Check if admin user already exists
                if (userDetailsRepository.findByUsername("admin").isEmpty()) {

                    // Create new admin user
                    Users users = new Users();
                    users.setUsername("admin");
                    users.setPassword(passwordEncoder.encode("admin123")); // Password should always be encoded
                    users.setRole("ROLE_ADMIN"); // Set role as admin

                    // Save admin user to database
                    userDetailsRepository.save(users);
                    System.out.println("Default Admin Role Created...!!!!");
                }
            } catch (Exception e) {
                throw new RuntimeException("Failed to create admin user", e);
            }
        };
    }
}
