package com.radsan.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "job_application")

public class Job_application {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "job_id")
	@JsonIgnore
	private Job_postings job_postings;
	
	private String applicant_name;
	private String applicant_email;
	private String resume_link;
	private String cover_letter;
	
	@CreationTimestamp
	@Column(name = "applied_at", updatable = false)
	private LocalDateTime appliedAt;
	
	public Job_application() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Job_postings getJob_postings() {
		return job_postings;
	}

	public void setJob_postings(Job_postings job_postings) {
		this.job_postings = job_postings;
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

	public LocalDateTime getAppliedAt() {
		return appliedAt;
	}

	public void setAppliedAt(LocalDateTime appliedAt) {
		this.appliedAt = appliedAt;
	}

	
	
	

}
