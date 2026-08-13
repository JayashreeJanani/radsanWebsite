package com.radsan.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Company_infoRequestDTO {
	@NotBlank(message = "Name cannot be emty")
	private String name;
	
	@NotBlank(message = "Address cannot be empty")
	private String address;
	
	@NotBlank(message = "Phone number cannot be empty")
	private String phone;
	
	@Email(message ="Email cannot be empty")
	private String email;
	
	@NotBlank(message ="About cannot be empty")
	private String about;
	
	public Company_infoRequestDTO() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}
	

}
