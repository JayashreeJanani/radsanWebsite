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

import com.radsan.entity.Faq;
import com.radsan.service.FAQService;

@RestController
@RequestMapping("/api/faqs")
public class FAQController {
	private final FAQService faqService;
	public FAQController(FAQService faqService) {
		this.faqService = faqService;
	}
	
	//for api: GET /api/faqs
	@GetMapping
	public List<Faq> getFaqs(){
		return faqService.getAllFaqs();
	}
	
	//for api: GET /api/faqs/{id}
	@GetMapping("/{id}")
	public Faq getFaqById(@PathVariable Integer id) {
		return faqService.getFaqById(id);
	}
	//for api: POST /api/faqs
	@PostMapping
	public Faq createFaqs(@RequestBody Faq faq) {
		return faqService.createFaq(faq);
	}
	
	//for api: PUT /api/faqs/{id}
	@PutMapping("/{id}")
	public Faq updateFaqs(@PathVariable Integer id, @RequestBody Faq faq) {
		return faqService.updateFaq(id, faq);
	}
	
	//for api:DELETE /api/faqs/{id}
	@DeleteMapping("/{id}")
	public String deleteFaqs(@PathVariable Integer id) {
		faqService.deleteFaq(id);
		return "This FAQ is now deleted";
	}
}
