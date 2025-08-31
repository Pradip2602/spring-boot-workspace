package com.code.SpringJWTAuth.service;

import com.code.SpringJWTAuth.entity.Users;
import com.code.SpringJWTAuth.repository.UserDetailsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminUserInitializer {

    @Bean
    public CommandLineRunner createAdminUser(UserDetailsRepository userDetailsRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            try {
                if (userDetailsRepository.findByUsername("admin").isEmpty()) {
                    Users users = new Users();
                    users.setUsername("admin");
                    users.setPassword(passwordEncoder.encode("admin123"));
                    users.setRole("ROLE_ADMIN");

                    userDetailsRepository.save(users);
                    System.out.println("Default Admin Role Created...!!!!");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

}
