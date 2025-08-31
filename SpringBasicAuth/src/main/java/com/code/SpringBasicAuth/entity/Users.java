package com.code.SpringBasicAuth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Users entity represents a user in the application.
 * - Implements UserDetails to integrate with Spring Security authentication.
 * - Stores username, password, and role information in the database.
 */
@Entity
@AllArgsConstructor // Generates constructor with all fields
@NoArgsConstructor  // Generates default no-args constructor
@Getter             // Generates getters for all fields
@Setter             // Generates setters for all fields
@ToString           // Generates a toString() method for debugging
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generated primary key
    private Long id;

    private String username; // Username for authentication
    private String password; // Encoded password for authentication
    private String role;     // User role (e.g., ROLE_ADMIN, ROLE_USER)

    /**
     * Returns the authorities granted to the user.
     * Spring Security uses this to check roles/permissions.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    /**
     * Returns the username used for authentication.
     */
    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * Indicates whether the user's account has expired.
     * Default implementation returns true.
     */
    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    /**
     * Indicates whether the user is locked or unlocked.
     * Default implementation returns true.
     */
    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    /**
     * Indicates whether the user's credentials (password) has expired.
     * Default implementation returns true.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    /**
     * Indicates whether the user is enabled or disabled.
     * Default implementation returns true.
     */
    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
