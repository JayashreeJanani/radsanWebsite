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

}
