package com.radsan.dto;

import java.time.LocalDateTime;

public class Job_postingsResponseDTO {
	
	private Integer id;
	private String title;
	private String description;
	private Boolean is_active;
	private LocalDateTime postedAt;
	
	public Job_postingsResponseDTO() {}

	public Job_postingsResponseDTO(Integer id, String title, String description, Boolean is_active,
			LocalDateTime postedAt) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.is_active = is_active;
		this.postedAt = postedAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public LocalDateTime getPostedAt() {
		return postedAt;
	}

	public void setPostedAt(LocalDateTime postedAt) {
		this.postedAt = postedAt;
	}
	
	
	

}
