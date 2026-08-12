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

import com.radsan.dto.AdminRequestDTO;
import com.radsan.dto.AdminResponseDTO;
import com.radsan.entity.Admin_users;
import com.radsan.service.Admin_usersService;

@RestController
@RequestMapping("/api/admin_users")

public class Admin_usersController {
	
	public final Admin_usersService adminService;
	
	public Admin_usersController(Admin_usersService adminService) {
		this.adminService=adminService;
	}
	//for api: GET /api/admin_users
	@GetMapping
	public List<AdminResponseDTO> getAllAdmins(){
		return adminService.getAllAdminUsers();
	}
	
	//for api: GET /api/admin_users/{id}
	@GetMapping("/{id}")
	public AdminResponseDTO getAdminById(@PathVariable Integer id) {
		return adminService.getAdminUsersById(id);
	}
	
	@PostMapping
	public AdminResponseDTO createAdmins(@RequestBody AdminRequestDTO admin_users) {
		return adminService.createAdmin_users(admin_users);
	}
	
	@PutMapping("/{id}")
	public AdminResponseDTO updateAdmins(@PathVariable Integer id, @RequestBody AdminRequestDTO admin_users) {
		return adminService.updateAdmin_users(id, admin_users);
	}
	
	//for api: DELETE /api/admin_users
	
	@DeleteMapping("/{id}")
	public String DeleteAdmins(@PathVariable Integer id) {
		adminService.deleteAdmin_users(id);
		return "This admin is deleted";
	}
}
