package com.radsan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.radsan.dto.Company_infoRequestDTO;
import com.radsan.dto.Company_infoResponseDTO;
import com.radsan.entity.Company_info;
import com.radsan.exception.ResourceNotFoundException;
import com.radsan.respository.Company_infoRepository;

@Service
public class Company_infoService {
	private final Company_infoRepository companyInfoRepository;
	
	public Company_infoService(Company_infoRepository companyInfoRepository) {
		this.companyInfoRepository = companyInfoRepository;
	}
	
	//for api: GET /api/company_info
	public List<Company_infoResponseDTO> getAllCompanyInfo(){
		return companyInfoRepository.findAll().stream().map(company_info -> new Company_infoResponseDTO(company_info.getId(),
				company_info.getName(), 				
				company_info.getAddress(),
				company_info.getPhone(),
				company_info.getEmail(),
				company_info.getAbout()
				)).toList();
				
	}
	// for api:GET /api/company_info/{id}
	public Company_infoResponseDTO getCompanyInfoById(Integer id){
		Company_info company_info =  companyInfoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Blog not found with id: " + id));
		Company_infoResponseDTO companyResponseDto = new Company_infoResponseDTO();
		companyResponseDto.setId(company_info.getId());
		companyResponseDto.setName(company_info.getName());
		companyResponseDto.setAddress(company_info.getAddress());
		companyResponseDto.setPhone(company_info.getPhone());
		companyResponseDto.setEmail(company_info.getEmail());
		companyResponseDto.setAbout(company_info.getAbout());
		
		return companyResponseDto;
				
	}
	
	//for api:POST /api/company_info
	public Company_infoResponseDTO createCompanyInfo(Company_infoRequestDTO company_infoRequestDto) {
		
		
		Company_info company = new Company_info();
		company.setName(company_infoRequestDto.getName());
		company.setAddress(company_infoRequestDto.getAddress());
		company.setPhone(company_infoRequestDto.getPhone());
		company.setEmail(company_infoRequestDto.getEmail());
		company.setAbout(company_infoRequestDto.getAbout());
		Company_info savedCompanyInfo =  companyInfoRepository.save(company);
		Company_infoResponseDTO company_infoResponseDto = new Company_infoResponseDTO();
		company_infoResponseDto.setId(savedCompanyInfo.getId());
		company_infoResponseDto.setName(savedCompanyInfo.getName());
		company_infoResponseDto.setAddress(savedCompanyInfo.getAddress());
		company_infoResponseDto.setPhone(savedCompanyInfo.getPhone());
		company_infoResponseDto.setEmail(savedCompanyInfo.getEmail());
		company_infoResponseDto.setAbout(savedCompanyInfo.getAbout());
		
		return company_infoResponseDto;
	}
	
	//for api: PUT /api/company_info/{id}
	public Company_infoResponseDTO updateCompanyInfo(Integer id, Company_infoRequestDTO updatedCompanyInfo) {
		Company_info company_info = companyInfoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Company not found"));
		company_info.setName(updatedCompanyInfo.getName());
		company_info.setAddress(updatedCompanyInfo.getAddress());
		company_info.setPhone(updatedCompanyInfo.getPhone());
		company_info.setEmail(updatedCompanyInfo.getEmail());
		company_info.setAbout(updatedCompanyInfo.getAbout());
		Company_info updatedCompany = companyInfoRepository.save(company_info);
		Company_infoResponseDTO companyResponseDto = new Company_infoResponseDTO();
		
		companyResponseDto.setId(updatedCompany.getId());
		companyResponseDto.setName(updatedCompany.getName());
		companyResponseDto.setAddress(updatedCompany.getAddress());
		companyResponseDto.setPhone(updatedCompany.getPhone());
		companyResponseDto.setEmail(updatedCompany.getEmail());
		companyResponseDto.setAbout(updatedCompany.getAbout());
		
		return companyResponseDto;
	
		
		
	}

}
