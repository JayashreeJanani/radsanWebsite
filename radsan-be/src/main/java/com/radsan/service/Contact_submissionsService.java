package com.radsan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.radsan.dto.Contact_submissionsRequestDTO;
import com.radsan.dto.Contact_submissionsResponseDTO;
import com.radsan.entity.Contact_submissions;
import com.radsan.exception.ResourceAlreadyExistsException;
import com.radsan.exception.ResourceNotFoundException;
import com.radsan.respository.Contact_submissionsRepository;

@Service
public class Contact_submissionsService {
	private final Contact_submissionsRepository contactRepository;
	
	public Contact_submissionsService(Contact_submissionsRepository contactRepository) {
	
		this.contactRepository = contactRepository;
		
	}
//for  api: GET /api/contacts	
	public List<Contact_submissionsResponseDTO> getAllContacts(){
		return contactRepository.findAll()
				.stream().map(contacts -> new Contact_submissionsResponseDTO(
						contacts.getId(),
						contacts.getName(),
						contacts.getEmail(),
						contacts.getSubject(),
						contacts.getMessage()
						)).toList();
	}

	//for api: GET /api/contacts/{id}
	public Contact_submissionsResponseDTO getContactsById(Integer id) {
		Contact_submissions contact =  contactRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Blog not found with id: " + id));
		Contact_submissionsResponseDTO contactResponseDto = new Contact_submissionsResponseDTO();
		contactResponseDto.setId(contact.getId());
		contactResponseDto.setName(contact.getName());
		contactResponseDto.setEmail(contact.getEmail());
		contactResponseDto.setSubject(contact.getSubject());
		contactResponseDto.setMessage(contact.getMessage());
		
		return contactResponseDto;
		
	}
	
	//for api: POST /api/contacts
	public Contact_submissionsResponseDTO createContacts(Contact_submissionsRequestDTO contactRequestSubmissionsDTO) {
		
		if (contactRepository.existsByName(contactRequestSubmissionsDTO.getName())) {
		    throw new ResourceAlreadyExistsException(
		        "This contact already exists with name: "
		        + contactRequestSubmissionsDTO.getName()
		    );
		}
		
		Contact_submissions contactSubmissions = new Contact_submissions();
		contactSubmissions.setName(contactRequestSubmissionsDTO.getName());
		contactSubmissions.setEmail(contactRequestSubmissionsDTO.getEmail());
		contactSubmissions.setSubject(contactRequestSubmissionsDTO.getSubject());
		contactSubmissions.setMessage(contactRequestSubmissionsDTO.getMessage());
		
		Contact_submissions savedContacts = contactRepository.save(contactSubmissions);
		Contact_submissionsResponseDTO contact_submissionsDTO = new Contact_submissionsResponseDTO();
		contact_submissionsDTO.setId(savedContacts.getId());
		contact_submissionsDTO.setName(savedContacts.getName());
		contact_submissionsDTO.setEmail(savedContacts.getEmail());
		contact_submissionsDTO.setSubject(savedContacts.getSubject());
		contact_submissionsDTO.setMessage(savedContacts.getMessage());
		
		return contact_submissionsDTO;
	}
	
	//for api: DELETE /api/contacts/{id}
	public void deleteContacts(Integer id) {
		Contact_submissions contact_submissions = contactRepository.findById(id)
		.orElseThrow(() -> new RuntimeException("Blog not found with id: " + id));
		contactRepository.delete(contact_submissions);
	}
}
