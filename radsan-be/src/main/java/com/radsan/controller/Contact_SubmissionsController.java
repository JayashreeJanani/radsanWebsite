package com.radsan.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.radsan.entity.Contact_submissions;
import com.radsan.service.Contact_submissionsService;

@RestController
@RequestMapping("/api/contacts")
public class Contact_SubmissionsController {
	
	private Contact_submissionsService contactService;
	
	public Contact_SubmissionsController(Contact_submissionsService contactService) {
		this.contactService = contactService;
	}
	//for api: GET /api/contacts
	@GetMapping
	public List<Contact_submissions> getAllContacts(){
		return contactService.getAllContacts();
	}
	
	//for api: GET /api/contact/{id}
	@GetMapping("/{id}")
	public Contact_submissions getContactById(@PathVariable Integer id) {
		return contactService.getContactsById(id);
	}
	
	//for api: POST /api/contact
	@PostMapping
	public Contact_submissions createContact(@RequestBody Contact_submissions contact_submissions) {
		return contactService.createContacts(contact_submissions);
	}
	//for api: DELETE /api/contacts/{id}
	@DeleteMapping("/{id}")
	public String deleteContacts(@PathVariable Integer id) {
		contactService.deleteContacts(id);
		return "This Contact has been deleted";
	}
}
