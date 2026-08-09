package com.radsan.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.radsan.entity.Job_postings;
import com.radsan.service.Job_postingsService;

@RestController
@RequestMapping("/api/job_postings")
public class Job_postingsController {
	private final Job_postingsService jobPostingsService;
	
	public Job_postingsController(Job_postingsService jobPostingsService) {
		this.jobPostingsService = jobPostingsService;
	}
	
	@GetMapping
	public List<Job_postings> getAllPostings(){
		return jobPostingsService.getAllJobPostings();
	}
	
	@GetMapping("/{id}")
	public Job_postings getPostingById(@PathVariable Integer id) {
		return jobPostingsService.getJobPostingsId(id);
	}
	
	@PostMapping
	public Job_postings createPosting(@RequestBody Job_postings job_postings) {
		return jobPostingsService.createJobPostings(job_postings);
	}
	
	@PutMapping("/{id}")
	public Job_postings updatePostings(@PathVariable Integer id, @RequestBody Job_postings job_postings) {
		return jobPostingsService.updateJobPostings(id, job_postings);
	}
	
	@DeleteMapping("/{id}")
	public String deletePosting(@PathVariable Integer id) {
		jobPostingsService.deletePostings(id);
		return "Job Postings deleted";
	}

}
