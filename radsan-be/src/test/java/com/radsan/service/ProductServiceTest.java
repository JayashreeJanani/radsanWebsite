package com.radsan.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.radsan.dto.ProductRequestDTO;
import com.radsan.dto.ProductResponseDTO;
import com.radsan.entity.Category;
import com.radsan.entity.Product;
import com.radsan.exception.ResourceAlreadyExistsException;
import com.radsan.exception.ResourceNotFoundException;
import com.radsan.respository.CategoryRepository;
import com.radsan.respository.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
	@Mock
	ProductRepository productRepository;
	@Mock
	CategoryRepository categoryRepository;
	
	@InjectMocks
	ProductService productService;
	
	@Test
	void shouldReturnProductExists() {
		
		
		//Arrange
		
		//here we are faking the repos
		
		
		
		Category category = new Category();
		category.setId(2);
		
		Product product = new Product();
		
		product.setId(5);
		
		product.setCategory(category);
		
		product.setName("Test Product");
		
		  when(productRepository.findById(5))
          .thenReturn(Optional.of(product));	
		  
		  
		  //Act
		  ProductResponseDTO result = productService.getProductById(5);
		  
		  
		  //Assert
		  assertEquals(5,result.getId());
		  assertEquals(2,result.getCategoryId());
		  assertEquals("Test Product",result.getName());
		  
		  verify(productRepository).findById(5);
	}
	
	@Test
	void shouldThrowExceptionWhenProductDoesNotExist() {

	    // Arrange
	   


	    when(productRepository.findById(999))
	            .thenReturn(Optional.empty());

	    // Act + Assert
	    assertThrows(
	            ResourceNotFoundException.class,
	            () -> productService.getProductById(999)
	    );
	}
	@Test
	void shouldCreateProductSuccessfully() {

	    // Arrange
	 

	   

	    Category category = new Category();
	    category.setId(2);

	    ProductRequestDTO request = new ProductRequestDTO();
	    request.setCategoryId(2);
	    request.setName("New Product");
	    request.setDescription("Test description");
	    // set price using the type your DTO expects
	    request.setIsActive(true);

	    when(productRepository.existsByName("New Product"))
	            .thenReturn(false);

	    when(categoryRepository.findById(2))
	            .thenReturn(Optional.of(category));
	    Product savedProduct = new Product();
	    savedProduct.setId(10);
	    savedProduct.setCategory(category);
	    savedProduct.setName("New Product");
	    savedProduct.setDescription("Test description");
	    savedProduct.setIsActive(true);
	    
	    when(productRepository.save(any(Product.class)))
        .thenReturn(savedProduct);
	 // Act
	    ProductResponseDTO result =
	            productService.createProduct(request);

	    // Assert
	    assertEquals(10, result.getId());
	    assertEquals(2, result.getCategoryId());
	    assertEquals("New Product", result.getName());
	    assertEquals("Test description", result.getDescription());
	    assertEquals(true, result.getIsActive());
	    //verify
	    
	    verify(productRepository).existsByName("New Product");
	    verify(categoryRepository).findById(2);
	    verify(productRepository).save(any(Product.class));
	}
	
	@Test
	void shouldThrowExceptionWhenProductAlreadyExists() {

	    // Arrange
	 

	    ProductService productService =
	            new ProductService(productRepository, categoryRepository);

	    ProductRequestDTO request = new ProductRequestDTO();
	    request.setName("New Product");
	    request.setCategoryId(2);

	    when(productRepository.existsByName("New Product"))
	            .thenReturn(true);
	    /*ProductService: "Does New Product already exist?"

			Mock repository: "YES." ← true*/

	    // Act + Assert
	    assertThrows(
	            ResourceAlreadyExistsException.class,
	            () -> productService.createProduct(request)
	    );
	    verify(categoryRepository, never()).findById(2);
	    verify(productRepository, never()).save(any(Product.class));
	}
	
	@Test
	void shouldThrowExceptionWhenCategoryDoesNotExist() {

	    // Arrange
	    

	    ProductService productService =
	            new ProductService(productRepository, categoryRepository);
	    
	    when(categoryRepository.findById(999))
        .thenReturn(Optional.empty());
	    
	    ProductRequestDTO request = new ProductRequestDTO();
	    request.setName("New Product");
	    request.setCategoryId(999);
	    when(productRepository.existsByName("New Product"))
	    .thenReturn(false);
	    
	    assertThrows(
	            ResourceNotFoundException.class,
	            () -> productService.createProduct(request)
	    );
	    verify(productRepository, never()).save(any(Product.class));
	   
	}

}
