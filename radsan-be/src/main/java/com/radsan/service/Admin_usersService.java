package com.radsan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.radsan.entity.Admin_users;
import com.radsan.respository.Admin_usersRepository;

@Service
public class Admin_usersService {
	
	private final Admin_usersRepository adminRepository;
	
	public Admin_usersService(Admin_usersRepository adminRepository) {
		this.adminRepository = adminRepository;
	}
	
	//for api: GET /api/admin_users
	public List<Admin_users> getAllAdminUsers(){
		return adminRepository.findAll();
	}
	
	//for api: GET /api/admin_users/{id}
	public Admin_users getAdminUsersById(Integer id) {
		return adminRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Admin not found in id" +id));
	}
	
	//for api: POST /api/admin_users
	public Admin_users createAdmin_users(Admin_users admin_users) {
		return adminRepository.save(admin_users);
	}
	
	//for api: PUT /api/admin_users/{id}
	
	public Admin_users updateAdmin_users(Integer id, Admin_users updatedAdminUsers) {
		Admin_users admin_users = adminRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Admin not found in id" +id));
		admin_users.setUsername(updatedAdminUsers.getUsername());
		admin_users.setEmail(updatedAdminUsers.getEmail());
		admin_users.setPassword_hash(updatedAdminUsers.getPassword_hash());
		admin_users.setIs_active(updatedAdminUsers.getIs_active());
		
		return adminRepository.save(admin_users);
		
	}
	
	//for api: DELETE /api/admin_users
	public void deleteAdmin_users(Integer id) {
		Admin_users admin_users = adminRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Admin not found in id" +id));
		adminRepository.delete(admin_users);
	}

}
