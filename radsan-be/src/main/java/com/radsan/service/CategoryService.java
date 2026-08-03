package com.radsan.service;

import com.radsan.entity.Category;
import com.radsan.respository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class CategoryService {
	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> getAllCategories(){
		return categoryRepository.findAll();
	}
//for API GET /api/categories/{id}
	public Category getProductById(Integer id) {
	    return categoryRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
	}

//for API POST /api/categories
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	//for API PUT /api/categories/{id}
	public Category updateCategory(Integer id, Category updatedCategory) {

	    Category category = categoryRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Category not found"));
	    category.setName(updatedCategory.getName());
	    category.setDescription(updatedCategory.getDescription());

	    return categoryRepository.save(category);
	}
	//for api DELETE /api/categories/{id}
	public void deleteCategory(Integer id) {

	    Category category = categoryRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Category not found"));

	    categoryRepository.delete(category);
	}
}

