package com.radsan.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AdminRequestDTO {
	
	@NotBlank(message = "Username cannot be empty")
	private String username;
	
	@NotBlank(message = "Email cannot be empty")
	@Email
	private String email;
	
	@Pattern(
		    regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$",
		    message = "Password must contain uppercase, lowercase, number and special character"
		)
	private String password_hash;
	
	@NotNull(message = "Cannot be null should be true or false")
	private Boolean is_active;
	
	public AdminRequestDTO() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword_hash() {
		return password_hash;
	}

	public void setPassword_hash(String password_hash) {
		this.password_hash = password_hash;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}
	
}
