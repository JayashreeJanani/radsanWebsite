package com.radsan.dto;

public class AdminResponseDTO {
	private Integer id;
	
	private String username;
	private String email;
//	private String password_hash;
	private Boolean is_active;
	
	public AdminResponseDTO() {}

	public AdminResponseDTO(Integer id, String username, String email,  Boolean is_active) {
		this.id = id;
		this.username = username;
		this.email = email;
//		this.password_hash = password_hash;
		this.is_active = is_active;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

//	public String getPassword_hash() {
//		return password_hash;
//	}
//
//	public void setPassword_hash(String password_hash) {
//		this.password_hash = password_hash;
//	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}
	
	
}
