package com.radsan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.radsan.dto.Job_postingsRequestDTO;
import com.radsan.dto.Job_postingsResponseDTO;
import com.radsan.entity.Job_postings;
import com.radsan.exception.ResourceNotFoundException;
import com.radsan.respository.JobPostingsRepository;

@Service
public class Job_postingsService {
	private final JobPostingsRepository jobPostingsRepository;
	
	public Job_postingsService(JobPostingsRepository jobPostingsRepository) {
		this.jobPostingsRepository = jobPostingsRepository;
	}
	
	public List<Job_postingsResponseDTO> getAllJobPostings(){
		return jobPostingsRepository.findAll()
				.stream()
				.map(job_Postings -> new Job_postingsResponseDTO(
						job_Postings.getId(),
						job_Postings.getTitle(),
						job_Postings.getDescription(),
						job_Postings.getIs_active(),
						job_Postings.getPostedAt()
						)).toList();
	}
	
	public Job_postingsResponseDTO getJobPostingsId(Integer id){
		 Job_postings job_postings = jobPostingsRepository.findById(id)
		            .orElseThrow(() -> new ResourceNotFoundException("Postings  not found with id: " + id));
		 Job_postingsResponseDTO jobPostingsResponse = new Job_postingsResponseDTO();
		 jobPostingsResponse.setId(job_postings.getId());
		 jobPostingsResponse.setTitle(job_postings.getTitle());
		 jobPostingsResponse.setDescription(job_postings.getDescription());
		 jobPostingsResponse.setIs_active(job_postings.getIs_active());
		 jobPostingsResponse.setPostedAt(job_postings.getPostedAt());
		 
		 return jobPostingsResponse;
				
	}
	
	public Job_postingsResponseDTO createJobPostings(Job_postingsRequestDTO job_postingsRequestDTO) {
		Job_postings job_postings = new Job_postings();
		
		job_postings.setTitle(job_postingsRequestDTO.getTitle());
		job_postings.setDescription(job_postingsRequestDTO.getDescription());
		job_postings.setIs_active(job_postingsRequestDTO.getIs_active());
		
		Job_postings savedPostings =  jobPostingsRepository.save(job_postings);
		Job_postingsResponseDTO savedPostingsResponseDTO = new Job_postingsResponseDTO();
		
		savedPostingsResponseDTO.setId(savedPostings.getId());
		savedPostingsResponseDTO.setTitle(savedPostings.getTitle());
		savedPostingsResponseDTO.setDescription(savedPostings.getDescription());
		savedPostingsResponseDTO.setIs_active(savedPostings.getIs_active());
		savedPostingsResponseDTO.setPostedAt(savedPostings.getPostedAt());
		
		return savedPostingsResponseDTO;
		
		
	}
	
	public Job_postingsResponseDTO updateJobPostings(Integer id, Job_postingsRequestDTO updated_job_postings) {
		Job_postings job_postings = jobPostingsRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " +id));
		job_postings.setTitle(updated_job_postings.getTitle());
		job_postings.setDescription(updated_job_postings.getDescription());
		job_postings.setIs_active(updated_job_postings.getIs_active());
		
		Job_postings updatedPostings =  jobPostingsRepository.save(job_postings);
		
		Job_postingsResponseDTO updatedPostingsResponseDTO = new Job_postingsResponseDTO();
		
		updatedPostingsResponseDTO.setId(updatedPostings.getId());
		updatedPostingsResponseDTO.setTitle(updatedPostings.getTitle());
		updatedPostingsResponseDTO.setDescription(updatedPostings.getDescription());
		updatedPostingsResponseDTO.setIs_active(updatedPostings.getIs_active());
		updatedPostingsResponseDTO.setPostedAt(updatedPostings.getPostedAt());
		
		return updatedPostingsResponseDTO;
		
		
	}
	
	public void deletePostings(Integer id) {
		Job_postings job_postings = jobPostingsRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: "+ id));
		jobPostingsRepository.delete(job_postings);
	}

}
