package com.radsan.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.radsan.entity.Job_postings;

public interface JobPostingsRepository extends JpaRepository<Job_postings,Integer> {

}
