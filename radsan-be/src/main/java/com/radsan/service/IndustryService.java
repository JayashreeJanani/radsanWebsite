package com.radsan.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.radsan.entity.Industry;

import com.radsan.respository.IndustryRepository;

@Service
public class IndustryService {
	
	private final IndustryRepository irRepository;
	
	public IndustryService(IndustryRepository irRepository) {
		this.irRepository = irRepository;
	}
//for API: GET /api/industries
	public List<Industry> getAllIndustries(){
		return irRepository.findAll();
	}
//for API: GET /api/industries/{id}
	public Industry getIndustryById(Integer id) {
	    return irRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Industry not found with id: " + id));
	}
	//for api POST /api/industries
	public Industry createIndustry(Industry industry) {
		return irRepository.save(industry);
	}
//for api PUT /api/industries
 public Industry updateIndustry(Integer id, Industry updatedIndustry) {

	    Industry industry = irRepository.findById(id)
	    		.orElseThrow(() ->
	    	    new RuntimeException("Industry not found with id: " + id)
	    	);
	    industry.setName(updatedIndustry.getName());
	    industry.setDescription(updatedIndustry.getDescription());
	   

	    return irRepository.save(industry);
	}
 //for api DELETE /api/industries/{id}	
 public void deleteIndustry(Integer id) {

	    Industry industry =irRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Industry not found with id: " + id));

	    irRepository.delete(industry);
	} 
	 
}
