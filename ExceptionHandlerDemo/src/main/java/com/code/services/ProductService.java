package com.code.services;

import java.util.List;

import com.code.entities.Product;

public interface ProductService {

	public List<Product> getAllProduct();

	public Product getProductById(long productId);

	public Product getProductByName(String productName);

	public Product addProduct(Product product);
}
