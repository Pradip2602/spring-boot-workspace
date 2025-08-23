package com.code.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.entities.Product;
import com.code.exceptions.ProductNotFoundException;
import com.code.repositories.ProductRepository;
import com.code.services.ProductService;

@Service
public class ProductServiceimpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(long productId) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("Product Not Found with Id : " + productId));
		return product;
	}

	@Override
	public Product getProductByName(String productName) {
		Product product = productRepository.findByProductName(productName)
				.orElseThrow(() -> new ProductNotFoundException("Product Not Found with Name : " + productName));
		return product;
	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

}
