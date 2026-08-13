package com.radsan.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Job_postingsRequestDTO {
	
	@NotBlank(message = "Title cannot be empty")
	private String title;
	
	@NotBlank(message = "Description cannot be empty")
	private String description;
	
	@NotNull(message = "Can be only true or false")
	private Boolean is_active;
	
	public Job_postingsRequestDTO(){}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}
	
	

}
