package com.radsan.dto;

import jakarta.validation.constraints.NotBlank;

public class IndustryRequestDTO {
	
	@NotBlank(message = "Industry name is required")
	private String name;//industry name
	
	@NotBlank(message ="Industry description is required")
	private String description;//description  of the industry
	
	public IndustryRequestDTO() {}

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
