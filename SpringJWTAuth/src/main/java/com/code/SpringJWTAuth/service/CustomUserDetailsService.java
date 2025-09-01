package com.code.SpringJWTAuth.service;

import com.code.SpringJWTAuth.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Custom implementation of Spring Security's UserDetailsService.
 * Responsible for loading user-specific data during authentication.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserDetailsRepository userDetailsRepository; // Repository to access user data from the database

    /**
     * Loads a user by username.
     * This method is called by Spring Security during authentication.
     *
     * @param username the username identifying the user whose data is required
     * @return UserDetails object containing user information
     * @throws UsernameNotFoundException if the user is not found in the database
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDetailsRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
