package com.radsan.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.radsan.service.ProductService;
import com.radsan.entity.Product;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	private final ProductService service;
	public ProductController(ProductService service) {
		this.service = service;
	}

	@GetMapping
	public List<Product> getProducts(){
		return service.getAllProducts();
	}
}
