package com.radsan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.radsan.entity.Product;
import com.radsan.respository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository repository;
	
	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}
	
	public List<Product> getAllProducts(){
		return repository.findAll();
	}
	public Product getProductById(Integer id) {
	    return repository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
	}
	//for api POST /api/products
	public Product createProduct(Product product) {
		return repository.save(product);
	}
	//BTS: if the object has no id Hibernate performs "INSERT INTO products(...)"
	//if object already had an id, Hibernate performs:
	//UPDATE products ...
	public Product updateProduct(Integer id, Product updatedProduct) {

	    Product product = repository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Product not found"));

	    product.setName(updatedProduct.getName());
	    product.setDescription(updatedProduct.getDescription());
	    product.setPrice(updatedProduct.getPrice());
	    product.setIsActive(updatedProduct.getIsActive());
	    product.setCategory(updatedProduct.getCategory());

	    return repository.save(product);
	}
	
	
	public void deleteProduct(Integer id) {

	    Product product = repository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Product not found"));

	    repository.delete(product);
	}
}
