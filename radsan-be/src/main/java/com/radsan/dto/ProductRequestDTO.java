package com.radsan.dto;

import java.math.BigDecimal;

import com.radsan.entity.Category;

public class ProductRequestDTO {
	
	private Integer categoryId;
	private String name;
	private String description;
	private BigDecimal price;
	private Boolean isActive;
	
	public ProductRequestDTO() {}

	
	public Integer getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}


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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
