package com.radsan.service;

import com.radsan.dto.CategoryRequestDTO;
import com.radsan.dto.CategoryResponseDTO;
import com.radsan.entity.Category;
import com.radsan.exception.ResourceNotFoundException;
import com.radsan.respository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class CategoryService {
	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<CategoryResponseDTO> getAllCategories(){
		return categoryRepository.findAll()
				.stream()
				.map(category -> new CategoryResponseDTO(
						category.getId(),
						category.getName(),
						category.getDescription()
						)).toList();
	}
//for API GET /api/categories/{id}
	public CategoryResponseDTO getProductById(Integer id) {
		Category category = categoryRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
		
		CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
		
		categoryResponseDTO.setId(category.getId());
		categoryResponseDTO.setName(category.getName());
		categoryResponseDTO.setDescription(category.getDescription());
		
		return categoryResponseDTO;
	}

//for API POST /api/categories
	public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO) {
		Category category = new Category();
		category.setName(categoryRequestDTO.getName());
		category.setDescription(categoryRequestDTO.getDescription());
				
		Category savedCategory = categoryRepository.save(category);
		CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
		
		categoryResponseDTO.setId(savedCategory.getId());
		categoryResponseDTO.setName(savedCategory.getName());
		categoryResponseDTO.setDescription(savedCategory.getDescription());
		
		return categoryResponseDTO;
	}
	//for API PUT /api/categories/{id}
	public CategoryResponseDTO updateCategory(Integer id, CategoryRequestDTO updatedCategory) {

	    Category category = categoryRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
	    category.setName(updatedCategory.getName());
	    category.setDescription(updatedCategory.getDescription());

	    Category updatedCategories = categoryRepository.save(category);
	    CategoryResponseDTO updatedCategoryResponseDTO = new CategoryResponseDTO();
	    
	    updatedCategoryResponseDTO.setId(updatedCategories.getId());
	    updatedCategoryResponseDTO.setName(updatedCategories.getName());
	    updatedCategoryResponseDTO.setDescription(updatedCategories.getDescription());
	    
	    return updatedCategoryResponseDTO;
	    
	}
	//for api DELETE /api/categories/{id}
	public void deleteCategory(Integer id) {

	    Category category = categoryRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));

	    categoryRepository.delete(category);
	}
}

