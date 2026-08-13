package com.radsan.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoryRequestDTO {
	
	@NotBlank(message = "Name should not be emty")
	private String name;
	
	@NotBlank(message ="Description not be empty")
	private String description;
	
	public CategoryRequestDTO() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
