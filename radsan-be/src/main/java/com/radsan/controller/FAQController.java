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

import com.radsan.dto.FAQRequestDTO;
import com.radsan.dto.FAQResponseDTO;
import com.radsan.entity.Faq;
import com.radsan.service.FAQService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/faqs")
public class FAQController {
	private final FAQService faqService;
	public FAQController(FAQService faqService) {
		this.faqService = faqService;
	}
	
	//for api: GET /api/faqs
	@GetMapping
	public List<FAQResponseDTO> getFaqs(){
		return faqService.getAllFaqs();
	}
	
	//for api: GET /api/faqs/{id}
	@GetMapping("/{id}")
	public FAQResponseDTO getFaqById(@PathVariable Integer id) {
		return faqService.getFaqById(id);
		
	}
	//for api: POST /api/faqs
	@PostMapping
	public FAQResponseDTO createFaqs(@Valid @RequestBody FAQRequestDTO faqResponseDto) {
		return faqService.createFaq(faqResponseDto);
	}
	
	//for api: PUT /api/faqs/{id}
	@PutMapping("/{id}")
	public FAQResponseDTO updateFaqs(@PathVariable Integer id, @Valid @RequestBody FAQRequestDTO faqRequestDto) {
		return faqService.updateFaq(id, faqRequestDto);
	}
	
	//for api:DELETE /api/faqs/{id}
	@DeleteMapping("/{id}")
	public String deleteFaqs(@PathVariable Integer id) {
		faqService.deleteFaq(id);
		return "This FAQ is now deleted";
	}
}
