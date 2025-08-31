package com.code.SpringBasicAuth.service;

import com.code.SpringBasicAuth.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
 * Custom implementation of Spring Security's UserDetailsService.
 * - Loads user details (username, password, roles) from the database.
 * - Used by Spring Security during authentication to verify credentials.
 */
@Service // Marks this class as a Spring-managed service component
public class CustomUserDetailsService implements UserDetailsService {

    // Repository for accessing user data from the database
    @Autowired
    UserDetailsRepository userDetailsRepository;

    /**
     * Loads a user by their username.
     * - Spring Security automatically calls this method during authentication.
     * - If the user exists, returns a UserDetails object (username, password, roles).
     * - If not, throws UsernameNotFoundException.
     *
     * @param username the username to look up
     * @return UserDetails object containing user data for authentication
     * @throws UsernameNotFoundException if no user is found with the given username
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Query database for user with given username
        return userDetailsRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("username not found."));
    }
}
