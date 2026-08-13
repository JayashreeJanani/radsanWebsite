package com.radsan.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Blog_postsRequestDTO {
	
	@NotBlank(message = "Title should not be empty")
	private String title;
	
	@NotBlank(message = "Slug is required")
	@Size(max = 150, message = "Slug must not exceed 150 characters")
	@Pattern(
	    regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$",
	    message = "Slug must contain lowercase letters, numbers, and hyphens only"
	)
	private String slug;
	
	@NotBlank(message = "Content should not be empty")
	private String content;
	
	@NotNull(message = "Published status is required")
	private Boolean isPublished;
	
	public Blog_postsRequestDTO() {}

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getIsPublished() {
		return isPublished;
	}

	public void setIsPublished(Boolean isPublished) {
		this.isPublished = isPublished;
	}
	
	
}
