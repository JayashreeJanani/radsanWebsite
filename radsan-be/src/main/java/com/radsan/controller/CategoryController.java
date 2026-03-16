package com.radsan.controller;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.radsan.entity.Category;
import com.radsan.service.CategoryService;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	private final CategoryService service;
	
	public CategoryController(CategoryService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Category> getCategories(){
		return service.getAllCategories();
	}

}
