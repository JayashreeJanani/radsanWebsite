package com.radsan.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.radsan.entity.Admin_users;

public interface Admin_usersRepository extends JpaRepository<Admin_users, Integer> {
	
	boolean existsByEmail(String email);

	boolean existsByUsername(String username);
	
	Optional<Admin_users> findByEmail(String email);

}
