package com.radsan.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.radsan.service.ProductService;
import com.radsan.dto.ProductRequestDTO;
import com.radsan.dto.ProductResponseDTO;
import com.radsan.entity.Product;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	private final ProductService service;
	public ProductController(ProductService service) {
		this.service = service;
	}

	@GetMapping
	public List<ProductResponseDTO> getProducts(){
		return service.getAllProducts();
	}
	@GetMapping("/{id}")
	public ProductResponseDTO getProductById(@PathVariable Integer id) {
	    return service.getProductById(id);
	}
	@PostMapping
	public ProductResponseDTO createProduct(@RequestBody ProductRequestDTO product) {
		return service.createProduct(product);
		
	}
	@PutMapping("/{id}")
	public ProductResponseDTO updateProduct(@PathVariable Integer id,
	                             @RequestBody ProductRequestDTO product) {

	    return service.updateProduct(id, product);
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Integer id) {

	    service.deleteProduct(id);

	    return "Product deleted successfully.";
	}
}
