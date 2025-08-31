package com.code.SpringBasicAuth.repository;

import com.code.SpringBasicAuth.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for accessing Users data from the database.
 * - Extends JpaRepository to inherit CRUD operations (save, findAll, findById, delete, etc.).
 * - Declares a custom method to find a user by username.
 * <p>
 * NOTE: Spring Security's UserDetailsService will call this repository to
 * fetch user data when authenticating users.
 */
@Repository // Marks this as a Spring-managed bean for persistence layer
public interface UserDetailsRepository extends JpaRepository<Users, Long> {

    /**
     * Finds a user by their username.
     * Spring Data JPA automatically implements this method by parsing its name.
     *
     * @param username the username to search for
     * @return Optional containing Users entity if found, empty otherwise
     */
    Optional<Users> findByUsername(String username);
}
