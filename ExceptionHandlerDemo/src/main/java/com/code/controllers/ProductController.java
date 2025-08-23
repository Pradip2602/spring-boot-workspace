package com.code.controllers;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.entities.ErrorRespose;
import com.code.entities.Product;
import com.code.exceptions.ProductNotFoundException;
import com.code.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
	}

	@GetMapping("/id/{productId}")
	public ResponseEntity<?> getProductById(@PathVariable long productId) {
		return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
	}

	@GetMapping("/name/{productName}")
	public ResponseEntity<?> getProductByName(@PathVariable String productName) {
		return new ResponseEntity<>(productService.getProductByName(productName), HttpStatus.OK);
	}
}
