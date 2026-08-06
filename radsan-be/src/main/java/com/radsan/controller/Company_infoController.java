package com.radsan.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.radsan.entity.Company_info;
import com.radsan.service.Company_infoService;

@RestController
@RequestMapping("/api/company_info")
public class Company_infoController {
	private Company_infoService companyInfoService;
	
	public Company_infoController(Company_infoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}
	//for api: GET /api/company_info
	@GetMapping
	public List<Company_info> getAllCompanyInfo(){
		return companyInfoService.getAllCompanyInfo();
	}
	// for api:GET /api/company_info/{id}
	@GetMapping("/{id}")
	public Company_info getCompanyInfoByID(@PathVariable Integer id) {
		return companyInfoService.getCompanyInfoById(id);
	}
	//for api: POST /api/company_info
	@PostMapping
	public Company_info createCompanyInfo(@RequestBody Company_info company_info) {
		return companyInfoService.createCompanyInfo(company_info);
	}
	//for api: PUT /api/company_info/{id}
	@PutMapping("/{id}")
	public Company_info updateCompany_info(@PathVariable Integer id, @RequestBody Company_info company_info) {
		return companyInfoService.updateCompanyInfo(id, company_info);
	}
}
