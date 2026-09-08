package com.radsan.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.radsan.entity.Job_application;

public interface JobApplicationRepository extends JpaRepository<Job_application, Integer> {

	@Query("""
	        SELECT COUNT(j) > 0
	        FROM Job_application j
	        WHERE j.job_postings.id = :jobId
	        AND j.applicant_email = :email
	    """)
	    boolean existsByJobAndEmail(
	            @Param("jobId") Integer jobId,
	            @Param("email") String email
	    );
	
}
