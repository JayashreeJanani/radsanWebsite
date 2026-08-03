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

import com.radsan.entity.Industry;

import com.radsan.service.IndustryService;

@RestController
@RequestMapping("/api/industries")
public class IndustryController {
	private final IndustryService iService;
	public IndustryController(IndustryService iService) {
		this.iService = iService;
	}
	//for API: GET /api/industries
 @GetMapping
	public List<Industry> getIndustries(){
		return iService.getAllIndustries();
	}
//for API: GET /api/industries/{id}
 @GetMapping("/{id}")
	public Industry getIndustryById(@PathVariable Integer id) {
	    return iService.getIndustryById(id);
	}
//for api POST /api/industries
 @PostMapping
	public Industry createIndustry(@RequestBody Industry industry) {
		return iService.createIndustry(industry);
		
	}
 //for api PUT /api/industries/{id}
 @PutMapping("/{id}")
	public Industry updateIndustry(@PathVariable Integer id,
	                             @RequestBody Industry industry) {

	    return iService.updateIndustry(id, industry);
	}
 //for api DELETE /api/industries/{id}
	@DeleteMapping("/{id}")
	public String deleteIndustry(@PathVariable Integer id) {

	    iService.deleteIndustry(id);

	    return "Industry deleted successfully.";
	}
	
  
}
