package com.radsan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.radsan.entity.Testimonials;
import com.radsan.respository.TestimonialsRepository;
@Service
public class TestimonialService {
	private TestimonialsRepository testimonialRepository;
	public TestimonialService(TestimonialsRepository testimonialRepository) {
		this.testimonialRepository = testimonialRepository;
	}
//for api: GET /api/testimonials	
	public List<Testimonials> getAllTestimonials(){
		return testimonialRepository.findAll(); 
	}
	
//for api: GET /api/testimonials
	public Testimonials getTestimonialById(Integer id) {
		return testimonialRepository.findById(id).orElseThrow(() -> new RuntimeException("Testimonial not found with id: " + id));
	}
	
// for api: POST /api/testimonials
	public Testimonials createTestimonials(Testimonials testimonials) {
		return testimonialRepository.save(testimonials);
		
	}

	//for api: PUT /api/testimonials/{id}
	public Testimonials updateTestimonials(Integer id, Testimonials updatedTestimonials) {
		Testimonials testimonials = testimonialRepository.findById(id).orElseThrow(() -> new RuntimeException("Testimonial not found"));
		testimonials.setClient_name(updatedTestimonials.getClient_name());
		testimonials.setCompany(updatedTestimonials.getCompany());
		testimonials.setFeedback(updatedTestimonials.getFeedback());
		
		return testimonialRepository.save(testimonials);
	}
	
	//for api: DELETE /api/testimonials/{id}
	public void deleteTestimonials(Integer id) {
		Testimonials testimonials = testimonialRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Testimonial not found"));
		testimonialRepository.delete(testimonials);
	}

}
