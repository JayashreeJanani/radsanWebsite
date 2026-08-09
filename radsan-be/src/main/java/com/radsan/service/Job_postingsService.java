package com.radsan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.radsan.entity.Job_postings;
import com.radsan.respository.JobPostingsRepository;

@Service
public class Job_postingsService {
	private final JobPostingsRepository jobPostingsRepository;
	
	public Job_postingsService(JobPostingsRepository jobPostingsRepository) {
		this.jobPostingsRepository = jobPostingsRepository;
	}
	
	public List<Job_postings> getAllJobPostings(){
		return jobPostingsRepository.findAll();
	}
	
	public Job_postings getJobPostingsId(Integer id){
		 return jobPostingsRepository.findById(id)
		            .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
				
	}
	
	public Job_postings createJobPostings(Job_postings job_postings) {
		return jobPostingsRepository.save(job_postings);
	}
	
	public Job_postings updateJobPostings(Integer id, Job_postings updated_job_postings) {
		Job_postings job_postings = jobPostingsRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Product not found with id: " +id));
		job_postings.setTitle(updated_job_postings.getTitle());
		job_postings.setDescription(updated_job_postings.getDescription());
		job_postings.setIs_active(updated_job_postings.getIs_active());
		
		return jobPostingsRepository.save(job_postings);
		
		
	}
	
	public void deletePostings(Integer id) {
		Job_postings job_postings = jobPostingsRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Product not found with id: "+ id));
		jobPostingsRepository.delete(job_postings);
	}

}
