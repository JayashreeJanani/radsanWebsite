package com.radsan.dto;

public class Job_ApplicationResponseDTO {
	
	private Integer id;
	private Integer job_id;
	private String applicant_name;
	private String applicant_email;
	private String resume_link;
	private String cover_letter;
	
	public Job_ApplicationResponseDTO() {}

	public Job_ApplicationResponseDTO(Integer id, Integer job_id, String applicant_name, String applicant_email,
			String resume_link, String cover_letter) {
		this.id = id;
		this.job_id = job_id;
		this.applicant_name = applicant_name;
		this.applicant_email = applicant_email;
		this.resume_link = resume_link;
		this.cover_letter = cover_letter;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
