package com.radsan.controller;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.radsan.dto.CategoryRequestDTO;
import com.radsan.dto.CategoryResponseDTO;
import com.radsan.entity.Category;
import com.radsan.service.CategoryService;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	private final CategoryService service;
	
	public CategoryController(CategoryService service) {
		this.service = service;
	}
//for API GET /api/categories
	@GetMapping
	public List<CategoryResponseDTO> getCategories(){
		return service.getAllCategories();
	}

//for API GET /api/categories/{id}
	@GetMapping("/{id}")
	public CategoryResponseDTO getcategoryById(@PathVariable Integer id) {
	    return service.getProductById(id);
	}
//for API POST /api/categories
	@PostMapping
	public CategoryResponseDTO createCategory(@RequestBody CategoryRequestDTO category) {
		return service.createCategory(category);
		
	}
	//for API PUT /api/categories/{id}
	@PutMapping("/{id}")
	 public CategoryResponseDTO updateCategory(@PathVariable Integer id,
	                             @RequestBody CategoryRequestDTO category) {

	    return service.updateCategory(id, category);
	}
//for api DELETE /api/categories/{id}
	@DeleteMapping("/{id}")
	public String deleteCategory(@PathVariable Integer id) {

	    service.deleteCategory(id);

	    return "Category deleted successfully.";
	}
	 
}
