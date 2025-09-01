package com.code.SpringJWTAuth.repository;

import com.code.SpringJWTAuth.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for Users entity.
 * Extends JpaRepository to provide standard CRUD operations.
 * Also provides a custom method to find a user by username, which is used for authentication.
 */
@Repository
public interface UserDetailsRepository extends JpaRepository<Users, Long> {

    /**
     * Finds a user by their username.
     *
     * @param username the username to search for
     * @return Optional containing the user if found, or empty if not found
     */
    Optional<Users> findByUsername(String username);

}
