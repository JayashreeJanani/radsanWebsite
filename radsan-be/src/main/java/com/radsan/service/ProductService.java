package com.radsan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.radsan.dto.ProductRequestDTO;
import com.radsan.dto.ProductResponseDTO;
import com.radsan.entity.Product;
import com.radsan.exception.ResourceNotFoundException;
import com.radsan.entity.Category;
import com.radsan.respository.CategoryRepository;
import com.radsan.respository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository repository;
	private final CategoryRepository categoryRepository;
	public ProductService(ProductRepository repository,CategoryRepository categoryRepository) {
		this.repository = repository;
		this.categoryRepository = categoryRepository;
	}
	
	public List<ProductResponseDTO> getAllProducts(){
		return repository.findAll()
				.stream()
				.map(products -> new ProductResponseDTO(
						products.getId(),
						products.getCategory().getId(),
						products.getName(),
						products.getDescription(),
						products.getPrice(),
						products.getIsActive()
						)).toList();
	}
	public ProductResponseDTO getProductById(Integer id) {
	    Product products = repository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
	    ProductResponseDTO productResponseDTO = new ProductResponseDTO();
	    productResponseDTO.setId(products.getId());
	    productResponseDTO.setCategoryId(products.getCategory().getId());
	    productResponseDTO.setName(products.getName());
	    productResponseDTO.setDescription(products.getDescription());
	    productResponseDTO.setPrice(products.getPrice());
	    productResponseDTO.setIsActive(products.getIsActive());
	    
	    return productResponseDTO;
	   
	    
	    
	  
	}
	//for api POST /api/products
	public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
		Category category = categoryRepository
	            .findById(productRequestDTO.getCategoryId())
	            .orElseThrow(() ->
	                    new ResourceNotFoundException(
	                            "Category not found with id: "
	                            + productRequestDTO.getCategoryId()
	                    ));

	    Product products = new Product();

	    products.setCategory(category);
	    products.setName(productRequestDTO.getName());
	    products.setDescription(productRequestDTO.getDescription());
	    products.setPrice(productRequestDTO.getPrice());
	    products.setIsActive(productRequestDTO.getIsActive());

	    Product savedProduct = repository.save(products);

	    ProductResponseDTO productResponseDTO = new ProductResponseDTO();

	    productResponseDTO.setId(savedProduct.getId());
	    productResponseDTO.setCategoryId(savedProduct.getCategory().getId());
	    productResponseDTO.setName(savedProduct.getName());
	    productResponseDTO.setDescription(savedProduct.getDescription());
	    productResponseDTO.setPrice(savedProduct.getPrice());
	    productResponseDTO.setIsActive(savedProduct.getIsActive());

	    return productResponseDTO;
	}
	//BTS: if the object has no id Hibernate performs "INSERT INTO products(...)"
	//if object already had an id, Hibernate performs:
	//UPDATE products ...
	public ProductResponseDTO updateProduct(
	        Integer id,
	        ProductRequestDTO updatedProduct) {

	    Product product = repository.findById(id)
	            .orElseThrow(() ->
	                    new ResourceNotFoundException(
	                            "Product not found with id: " + id
	                    ));

	    Category category = categoryRepository
	            .findById(updatedProduct.getCategoryId())
	            .orElseThrow(() ->
	                    new RuntimeException(
	                            "Category not found with id: "
	                            + updatedProduct.getCategoryId()
	                    ));

	    product.setName(updatedProduct.getName());
	    product.setDescription(updatedProduct.getDescription());
	    product.setPrice(updatedProduct.getPrice());
	    product.setIsActive(updatedProduct.getIsActive());
	    product.setCategory(category);

	    Product updatedProducts = repository.save(product);

	    ProductResponseDTO responseDTO = new ProductResponseDTO();

	    responseDTO.setId(updatedProducts.getId());
	    responseDTO.setCategoryId(updatedProducts.getCategory().getId());
	    responseDTO.setName(updatedProducts.getName());
	    responseDTO.setDescription(updatedProducts.getDescription());
	    responseDTO.setPrice(updatedProducts.getPrice());
	    responseDTO.setIsActive(updatedProducts.getIsActive());

	    return responseDTO;
	}
	
	
	public void deleteProduct(Integer id) {

	    Product product = repository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Product not found"));

	    repository.delete(product);
	}
}
