package com.radsan.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Contact_submissionsRequestDTO {
	
	@NotBlank(message = "name cannot be emty")
	private String name;
	
	@NotBlank(message = "email cannot be empty")
	@Email(message ="Email cannot be empty")
	private String email;
	
	@NotBlank(message = "Subject cannot be empty")
	private String subject;
	
	@NotBlank(message = "Message cannot be empty")
	private String message;
	
	public Contact_submissionsRequestDTO() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
