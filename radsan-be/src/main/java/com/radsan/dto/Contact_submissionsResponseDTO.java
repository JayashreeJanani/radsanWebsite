package com.radsan.dto;

public class Contact_submissionsResponseDTO {
	private Integer id;
	private String name;
	private String email;
	private String subject;
	private String message;
	
	public Contact_submissionsResponseDTO() {}

	public Contact_submissionsResponseDTO(Integer id, String name, String email, String subject, String message) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
