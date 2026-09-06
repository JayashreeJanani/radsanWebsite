package com.radsan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.radsan.dto.Job_ApplicationRequestDTO;
import com.radsan.dto.Job_ApplicationResponseDTO;
import com.radsan.entity.Job_application;
import com.radsan.entity.Job_postings;
import com.radsan.exception.ResourceNotFoundException;
import com.radsan.respository.JobApplicationRepository;
import com.radsan.respository.JobPostingsRepository;

@Service
public class Job_applicationService {
	private final JobApplicationRepository jobApplicationRepository;
	private final JobPostingsRepository jobPostingsRepository;
	
	public Job_applicationService(JobApplicationRepository jobApplicationRepository, JobPostingsRepository jobPostingsRepository ) {
		this.jobApplicationRepository = jobApplicationRepository;
		this.jobPostingsRepository = jobPostingsRepository;
	}
	
	//for api:GET /api/job_applications
	public List<Job_ApplicationResponseDTO> getAllJobApplications(){
		return jobApplicationRepository.findAll()
				.stream().map(jobApp -> new Job_ApplicationResponseDTO(
						jobApp.getId(),
						jobApp.getJob_postings().getId(),
						jobApp.getApplicant_name(),
						jobApp.getApplicant_email(),
						jobApp.getResume_link(),
						jobApp.getCover_letter()
						)).toList();
	}
	
	//for api: GET /api/job_applications/{id}
	public Job_ApplicationResponseDTO getJobApplicationById(Integer id) {
		Job_application job_application =  jobApplicationRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Job Application is not found in id:"+id));
		Job_ApplicationResponseDTO job_applicationResponseDTO = new Job_ApplicationResponseDTO();
		job_applicationResponseDTO.setId(job_application.getId());
		job_applicationResponseDTO.setJob_id(job_application.getJob_postings().getId());
		job_applicationResponseDTO.setApplicant_name(job_application.getApplicant_name());
		job_applicationResponseDTO.setApplicant_email(job_application.getApplicant_email());
		job_applicationResponseDTO.setResume_link(job_application.getResume_link());
		job_applicationResponseDTO.setCover_letter(job_application.getCover_letter());
		
		return job_applicationResponseDTO;
	}
	
	//for api: POST /api/job_applications
	public Job_ApplicationResponseDTO createJobApplications(Job_ApplicationRequestDTO job_applicationRequestDTO) {
		Job_postings job_postings =  jobPostingsRepository.findById(job_applicationRequestDTO.getJob_id())
	            .orElseThrow(() ->
                new ResourceNotFoundException(
                        "Job Application not found with id: "
                        + job_applicationRequestDTO.getJob_id()
                ));
		Job_application job_application = new Job_application();
		
		job_application.setJob_postings(job_postings);
		job_application.setApplicant_name(job_applicationRequestDTO.getApplicant_name());
		job_application.setApplicant_email(job_applicationRequestDTO.getApplicant_email());
		job_application.setResume_link(job_applicationRequestDTO.getResume_link());
		job_application.setCover_letter(job_applicationRequestDTO.getCover_letter());
		
		
		
		
		
		
		Job_application savedApplications = jobApplicationRepository.save(job_application);
		Job_ApplicationResponseDTO job_applicationResponseDTO = new Job_ApplicationResponseDTO();
		
		job_applicationResponseDTO.setId(savedApplications.getId());
		job_applicationResponseDTO.setJob_id(savedApplications.getJob_postings().getId());
		job_applicationResponseDTO.setApplicant_name(savedApplications.getApplicant_name());
		job_applicationResponseDTO.setApplicant_email(savedApplications.getApplicant_email());
		job_applicationResponseDTO.setResume_link(savedApplications.getResume_link());
		job_applicationResponseDTO.setCover_letter(savedApplications.getCover_letter());
		
		return job_applicationResponseDTO;
	}
	
	//for api: DELETE /api/job_applications/{id}
	public void deleteJobApplication(Integer id) {
		Job_application job_application = jobApplicationRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Job Application is not found in id:"+id));
		jobApplicationRepository.delete(job_application);
		
	}
	
	
	

}
