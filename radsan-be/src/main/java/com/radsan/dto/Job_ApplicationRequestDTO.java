package com.radsan.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Job_ApplicationRequestDTO {
	
	@NotNull(message = "Job ID is required")
	@Positive(message = "Job ID must be greater than 0")
	private Integer job_id;
	
	@NotBlank(message="Applicant name cannot be empty")
	private String applicant_name;
	
	@Email(message ="Email cannot be empty")
	private String applicant_email;
	
	@NotBlank(message = "Resume cannot be empty")
	private String resume_link;
	
	@NotBlank(message = "Cover letter cannot be empty")
	private String cover_letter;
	
	public Job_ApplicationRequestDTO() {}

	public Integer getJob_id() {
		return job_id;
	}

	public void setJob_id(Integer job_id) {
		this.job_id = job_id;
	}

	public String getApplicant_name() {
		return applicant_name;
	}

	public void setApplicant_name(String applicant_name) {
		this.applicant_name = applicant_name;
	}

	public String getApplicant_email() {
		return applicant_email;
	}

	public void setApplicant_email(String applicant_email) {
		this.applicant_email = applicant_email;
	}

	public String getResume_link() {
		return resume_link;
	}

	public void setResume_link(String resume_link) {
		this.resume_link = resume_link;
	}

	public String getCover_letter() {
		return cover_letter;
	}

	public void setCover_letter(String cover_letter) {
		this.cover_letter = cover_letter;
	}
	
	

}
