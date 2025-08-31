package com.code.SpringBasicAuth.service;

import com.code.SpringBasicAuth.entity.Users;
import com.code.SpringBasicAuth.repository.UserDetailsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * AdminUserInitializer automatically creates a default admin user
 * when the application starts, if it does not already exist.
 */
@Component // Marks this as a Spring-managed component
public class AdminUserInitializer {

    /**
     * Defines a CommandLineRunner bean that runs after the application context loads.
     * This will:
     * - Check if a user with username "admin" exists in the database.
     * - If not, create a new admin user with:
     * username: "admin"
     * password: "admin123" (stored in encoded form)
     * role: "ROLE_ADMIN"
     */
    @Bean
    public CommandLineRunner createAdminUser(UserDetailsRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Only create the admin user if it doesn't already exist
            if (userRepository.findByUsername("admin").isEmpty()) {
                Users admin = new Users();
                admin.setUsername("admin"); // Set default username
                admin.setPassword(passwordEncoder.encode("admin123")); // Encode password using BCrypt (or your configured encoder)
                admin.setRole("ROLE_ADMIN"); // Assign admin role

                userRepository.save(admin); // Save user in database
                System.out.println("Default admin user created...!"); // Log to console for confirmation
            }
        };
    }
}
