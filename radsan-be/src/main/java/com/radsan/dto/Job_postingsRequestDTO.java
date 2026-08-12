package com.radsan.dto;

public class Job_postingsRequestDTO {
	
	private String title;
	private String description;
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
