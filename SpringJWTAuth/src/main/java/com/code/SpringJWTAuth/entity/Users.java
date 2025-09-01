package com.code.SpringJWTAuth.entity;

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
 * Entity representing a User in the system.
 * Implements Spring Security's UserDetails to integrate with authentication.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Primary key, auto-generated

    private String username; // Username for authentication

    private String password; // Password (should be stored encoded)

    private String role; // User role (e.g., "ROLE_USER", "ROLE_ADMIN")

    /**
     * Returns the authorities granted to the user.
     * Converts the role into a SimpleGrantedAuthority for Spring Security.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
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
     * Indicates whether the user's account is locked.
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
