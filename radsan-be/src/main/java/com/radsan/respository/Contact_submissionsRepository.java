package com.radsan.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.radsan.entity.Contact_submissions;

public interface Contact_submissionsRepository extends JpaRepository<Contact_submissions, Integer> {

	boolean existsByName(String name);
}
