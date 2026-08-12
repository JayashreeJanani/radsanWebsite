package com.radsan.dto;

import java.time.LocalDateTime;

public class Blog_postsResponseDTO {
	
	private Integer id;
	private String title;
	private String slug;
	private String content;
	private Boolean isPublished;
	private LocalDateTime publishedAt;
	
	public Blog_postsResponseDTO() {}

	public Blog_postsResponseDTO(Integer id, String title, String slug, String content, Boolean isPublished,
			LocalDateTime publishedAt) {
		this.id = id;
		this.title = title;
		this.slug = slug;
		this.content = content;
		this.isPublished = isPublished;
		this.publishedAt = publishedAt;
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

	public LocalDateTime getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(LocalDateTime publishedAt) {
		this.publishedAt = publishedAt;
	}
	
	

}
