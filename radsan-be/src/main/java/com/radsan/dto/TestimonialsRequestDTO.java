package com.radsan.dto;

public class TestimonialsRequestDTO {
	
	private String client_name;
	private String company;
	private String feedback;
	
	public TestimonialsRequestDTO() {}

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
