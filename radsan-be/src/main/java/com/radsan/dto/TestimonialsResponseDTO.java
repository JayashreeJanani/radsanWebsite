package com.radsan.dto;

public class TestimonialsResponseDTO {
	
	private Integer id;
	private String client_name;
	private String company;
	private String feedback;
	
	public TestimonialsResponseDTO() {}

	public TestimonialsResponseDTO(Integer id, String client_name, String company, String feedback) {
		this.id = id;
		this.client_name = client_name;
		this.company = company;
		this.feedback = feedback;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
	
	
}
