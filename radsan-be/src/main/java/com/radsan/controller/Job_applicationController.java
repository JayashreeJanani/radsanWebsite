package com.radsan.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.radsan.dto.Job_ApplicationRequestDTO;
import com.radsan.dto.Job_ApplicationResponseDTO;
import com.radsan.entity.Job_application;
import com.radsan.service.Job_applicationService;

@RestController
@RequestMapping("/api/job_application")

public class Job_applicationController {
	private final Job_applicationService jobApplicationService;
	
	public Job_applicationController(Job_applicationService jobApplicationService) {
		this.jobApplicationService = jobApplicationService;
	}
//for api: GET /api/job_application
	@GetMapping
	public List<Job_ApplicationResponseDTO> getAllApplications(){
		return jobApplicationService.getAllJobApplications();
	}
	
//for api: GET/api/job_application/{id}
	@GetMapping("/{id}")
	public Job_ApplicationResponseDTO getApplicationById(@PathVariable Integer id) {
		return jobApplicationService.getJobApplicationById(id);
	}
	//for api: POST /api/job_application
	@PostMapping
	public Job_ApplicationResponseDTO createApplication(@RequestBody Job_ApplicationRequestDTO job_application) {
		return jobApplicationService.createJobApplications(job_application);
	}
	
	//for api: DELETE /api/job_application/{id}
	@DeleteMapping("/{id}")
	public String deleteApplication(@PathVariable Integer id) {
		jobApplicationService.deleteJobApplication(id);
		return "This Application is no longer available";
	}
}
