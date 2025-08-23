package com.code.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> findByProductName(String productName);
	
}
