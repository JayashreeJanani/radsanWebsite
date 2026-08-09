package com.radsan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.radsan.entity.Job_application;
import com.radsan.respository.JobApplicationRepository;

@Service
public class Job_applicationService {
	private final JobApplicationRepository jobApplicationRepository;
	
	public Job_applicationService(JobApplicationRepository jobApplicationRepository) {
		this.jobApplicationRepository = jobApplicationRepository;
	}
	
	//for api:GET /api/job_applications
	public List<Job_application> getAllJobApplications(){
		return jobApplicationRepository.findAll();
	}
	
	//for api: GET /api/job_applications/{id}
	public Job_application getJobApplicationById(Integer id) {
		return jobApplicationRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Job Application is not found in id:"+id));
	}
	
	//for api: POST /api/job_applications
	public Job_application createJobApplications(Job_application job_application) {
		return jobApplicationRepository.save(job_application);
	}
	
	//for api: DELETE /api/job_applications/{id}
	public void deleteJobApplication(Integer id) {
		Job_application job_application = jobApplicationRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Job Application is not found in id:"+id));
		jobApplicationRepository.delete(job_application);
		
	}
	
	
	

}
