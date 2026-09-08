package com.radsan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.radsan.dto.FAQRequestDTO;
import com.radsan.dto.FAQResponseDTO;
import com.radsan.entity.Faq;
import com.radsan.exception.ResourceAlreadyExistsException;
import com.radsan.exception.ResourceNotFoundException;
import com.radsan.respository.FaqRepository;

@Service
public class FAQService {
	private final FaqRepository faqRepository;
	
	public FAQService(FaqRepository faqRepository) {
		this.faqRepository=faqRepository;
	}
	
	//for api: GET /api/faqs
	public List<FAQResponseDTO> getAllFaqs(){
		
		return faqRepository.findAll()
		        .stream()
		        .map(faq -> new FAQResponseDTO(
		                faq.getId(),
		                faq.getQuestion(),
		                faq.getAnswer()
		        ))
		        .toList();// this is the extended version of it
		
		//List<Faq> faqs = faqRepository.findAll();
//		  
//
//		    List<FAQResponseDTO> responseDTOs = new ArrayList<>();
//
//		    for (Faq faq : faqs) {
//
//		        FAQResponseDTO responseDTO = new FAQResponseDTO();
//
//		        responseDTO.setId(faq.getId());
//		        responseDTO.setQuestion(faq.getQuestion());
//		        responseDTO.setAnswer(faq.getAnswer());
//
//		        responseDTOs.add(responseDTO);
//		    }
//
		 //   return responseDTOs;
	}
	
	//for api: GET /api/faqs/{id}
	public FAQResponseDTO getFaqById(Integer id) {
		Faq faq = faqRepository.findById(id)	    		
	            .orElseThrow(() -> new ResourceNotFoundException("Faq not found with id: " + id));
	            
	            FAQResponseDTO faqResponseDto = new FAQResponseDTO();
	            faqResponseDto.setId(faq.getId());
	            faqResponseDto.setQuestion(faq.getQuestion());
	            faqResponseDto.setAnswer(faq.getAnswer());
	            
	            return faqResponseDto;
	            }
	
	//for api: POST /api/faqs
	public FAQResponseDTO createFaq(FAQRequestDTO faqRequestDto) {
		
		if (faqRepository.existsByQuestion(faqRequestDto.getQuestion())) {
		    throw new ResourceAlreadyExistsException(
		        "Faqs already exists with name: "
		        + faqRequestDto.getQuestion()
		    );
		}
		
		Faq faq = new Faq();
		
		faq.setQuestion(faqRequestDto.getQuestion());
		faq.setAnswer(faqRequestDto.getAnswer());
		
	    Faq savedFaq = faqRepository.save(faq);
	    

	    FAQResponseDTO responseDTO = new FAQResponseDTO();

	    responseDTO.setId(savedFaq.getId());
	    responseDTO.setQuestion(savedFaq.getQuestion());
	    responseDTO.setAnswer(savedFaq.getAnswer());

	    return responseDTO;
	}
	
	//for api: PUT /api/faqs/{id}
	public FAQResponseDTO	updateFaq(Integer id, FAQRequestDTO faqRequestDto) {
		Faq faq = faqRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Faq not found with id: " + id));
		faq.setQuestion(faqRequestDto.getQuestion());
		faq.setAnswer(faqRequestDto.getAnswer());
		Faq updatedFaq =  faqRepository.save(faq);
		FAQResponseDTO responseDTO = new FAQResponseDTO();

	    responseDTO.setId(updatedFaq.getId());
	    responseDTO.setQuestion(updatedFaq.getQuestion());
	    responseDTO.setAnswer(updatedFaq.getAnswer());

	    return responseDTO;
		
		
	}
	
	//for api: DELETE /api/faqs/{id}
	public void deleteFaq(Integer id) {
		Faq faq = faqRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("FAQ not found"));
		 faqRepository.delete(faq);
		 
	}
}
