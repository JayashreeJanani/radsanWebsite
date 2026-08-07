package com.radsan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.radsan.entity.Contact_submissions;
import com.radsan.respository.Contact_submissionsRepository;

@Service
public class Contact_submissionsService {
	private final Contact_submissionsRepository contactRepository;
	
	public Contact_submissionsService(Contact_submissionsRepository contactRepository) {
	
		this.contactRepository = contactRepository;
		
	}
//for  api: GET /api/contacts	
	public List<Contact_submissions> getAllContacts(){
		return contactRepository.findAll();
	}

	//for api: GET /api/contacts/{id}
	public Contact_submissions getContactsById(Integer id) {
		return contactRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Blog not found with id: " + id));
		
	}
	
	//for api: POST /api/contacts
	public Contact_submissions createContacts(Contact_submissions contact_submissions) {
		return contactRepository.save(contact_submissions);
	}
	
	//for api: DELETE /api/contacts/{id}
	public void deleteContacts(Integer id) {
		Contact_submissions contact_submissions = contactRepository.findById(id)
		.orElseThrow(() -> new RuntimeException("Blog not found with id: " + id));
		contactRepository.delete(contact_submissions);
	}
}
