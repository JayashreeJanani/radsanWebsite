package com.radsan.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.radsan.entity.Job_application;

public interface JobApplicationRepository extends JpaRepository<Job_application, Integer> {

}
