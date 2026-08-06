package com.radsan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.radsan.entity.Company_info;
import com.radsan.respository.Company_infoRepository;

@Service
public class Company_infoService {
	private final Company_infoRepository companyInfoRepository;
	
	public Company_infoService(Company_infoRepository companyInfoRepository) {
		this.companyInfoRepository = companyInfoRepository;
	}
	
	//for api: GET /api/company_info
	public List<Company_info> getAllCompanyInfo(){
		return companyInfoRepository.findAll();
	}
	// for api:GET /api/company_info/{id}
	public Company_info getCompanyInfoById(Integer id){
		return companyInfoRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not found with id: " + id));
				
	}
	
	//for api:POST /api/company_info
	public Company_info createCompanyInfo(Company_info company_info) {
		return companyInfoRepository.save(company_info);
	}
	
	//for api: PUT /api/company_info/{id}
	public Company_info updateCompanyInfo(Integer id, Company_info updatedCompanyInfo) {
		Company_info company_info = companyInfoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Blog not found"));
		
		company_info.setName(updatedCompanyInfo.getName());
		company_info.setAddress(updatedCompanyInfo.getAddress());
		company_info.setPhone(updatedCompanyInfo.getPhone());
		company_info.setEmail(updatedCompanyInfo.getEmail());
		company_info.setAbout(updatedCompanyInfo.getAbout());
		
		return companyInfoRepository.save(company_info);
		
		
	}

}
