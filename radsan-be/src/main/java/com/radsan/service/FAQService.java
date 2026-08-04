package com.radsan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.radsan.entity.Faq;
import com.radsan.respository.FaqRepository;

@Service
public class FAQService {
	private final FaqRepository faqRepository;
	
	public FAQService(FaqRepository faqRepository) {
		this.faqRepository=faqRepository;
	}
	
	//for api: GET /api/faqs
	public List<Faq> getAllFaqs(){
		return faqRepository.findAll();
	}
	
	//for api: GET /api/faqs/{id}
	public Faq getFaqById(Integer id) {
	    return faqRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Faq not found with id: " + id));
	}
	
	//for api: POST /GET/faqs
	public Faq createFaq(Faq faqs) {
		return faqRepository.save(faqs);
	}
	
	//for api: PUT /api/faqs/{id}
	public Faq updateFaq(Integer id, Faq updatedFaqs) {
		Faq faq = faqRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Faq not found with id: " + id));
		faq.setQuestion(faq.getQuestion());
		faq.setAnswer(faq.getAnswer());
		
		return faqRepository.save(faq);
		
	}
	
	//for api: DELETE /api/faqs/{id}
	public void deleteFaq(Integer id) {
		Faq faq = faqRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("FAQ not found"));
		 faqRepository.delete(faq);
		 
	}
}
