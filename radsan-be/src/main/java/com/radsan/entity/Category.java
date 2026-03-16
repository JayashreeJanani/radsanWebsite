package com.radsan.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "categories")

public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String description;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	public Integer getId() {
		return id;
	}

	

	public String getName() {
		return name;
	}

	
	public String getDescription() {
		return description;
	}

	

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	
	

}
