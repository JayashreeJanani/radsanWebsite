package com.radsan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.radsan.dto.IndustryRequestDTO;
import com.radsan.dto.IndustryResponseDTO;
import com.radsan.entity.Industry;
import com.radsan.exception.ResourceNotFoundException;
import com.radsan.respository.IndustryRepository;

@Service
public class IndustryService {
	
	private final IndustryRepository irRepository;
	
	public IndustryService(IndustryRepository irRepository) {
		this.irRepository = irRepository;
	}
//for API: GET /api/industries
	public List<IndustryResponseDTO> getAllIndustries(){
		return irRepository.findAll()
				.stream()
				.map(industry -> new IndustryResponseDTO(
						industry.getId(),
						industry.getName(),
						industry.getDescription()
						)).toList();
	}
//for API: GET /api/industries/{id}
	public IndustryResponseDTO getIndustryById(Integer id) {
	    Industry industry =  irRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Industry not found with id: " + id));
	    IndustryResponseDTO industryResponseDto = new IndustryResponseDTO();
	    industryResponseDto.setId(industry.getId());
	    industryResponseDto.setName(industry.getName());
	    industryResponseDto.setDescription(industry.getDescription());
	    
	    return industryResponseDto;
	}
	//for api POST /api/industries
	public IndustryResponseDTO createIndustry(IndustryRequestDTO industryRequestDTO) {
		Industry industry = new Industry();
		industry.setName(industryRequestDTO.getName());
		industry.setDescription(industryRequestDTO.getDescription());
		
		Industry savedIndustry = irRepository.save(industry);
		IndustryResponseDTO industryResponseDTO = new IndustryResponseDTO();
		
		industryResponseDTO.setId(savedIndustry.getId());
		industryResponseDTO.setName(savedIndustry.getName());
		industryResponseDTO.setDescription(savedIndustry.getDescription());
		
		return industryResponseDTO;
	}
//for api PUT /api/industries
 public IndustryResponseDTO updateIndustry(Integer id, IndustryRequestDTO updatedIndustryDTO) {

	    Industry industry = irRepository.findById(id)
	    		.orElseThrow(() ->
	    	    new ResourceNotFoundException("Industry not found with id: " + id));
	    industry.setName(updatedIndustryDTO.getName());
	    industry.setDescription(updatedIndustryDTO.getDescription());
	   
	    Industry updatedIndustry = irRepository.save(industry);
		IndustryResponseDTO updatedIndustryResponseDTO = new IndustryResponseDTO();
		
		updatedIndustryResponseDTO.setId(updatedIndustry.getId());
		updatedIndustryResponseDTO.setName(updatedIndustry.getName());
		updatedIndustryResponseDTO.setDescription(updatedIndustry.getDescription());
		
		return updatedIndustryResponseDTO;
	}
 //for api DELETE /api/industries/{id}	
 public void deleteIndustry(Integer id) {

	    Industry industry =irRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Industry not found with id: " + id));

	    irRepository.delete(industry);
	} 
	 
}
