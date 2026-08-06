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

import com.radsan.entity.Testimonials;
import com.radsan.service.TestimonialService;

@RestController
@RequestMapping("/api/testimonials")
public class TestimonialsController {
	private TestimonialService testimonialService;
	public TestimonialsController(TestimonialService testimonialService) {
		this.testimonialService = testimonialService;
	}
//for api: GET /api/testimonials	
	@GetMapping
	public List<Testimonials> getTestimonials(){
		return testimonialService.getAllTestimonials();
	}
//for api: GET /api/testimonials/{id}	
	@GetMapping("/{id}")
	public Testimonials getTestimonialsByID(@PathVariable Integer id) {
		return testimonialService.getTestimonialById(id);
	}
//for api: POST /api/testimonials
	@PostMapping
	public Testimonials createTestimonials(@RequestBody Testimonials testimonials) {
		return testimonialService.createTestimonials(testimonials);
	}
	
//for api: PUT /api/testimonials/{id}
	@PutMapping("/{id}")
	public Testimonials updateTestimonials(@PathVariable Integer id,@RequestBody Testimonials testimonials) {
		return testimonialService.updateTestimonials(id, testimonials);
	}
	
	//for api: DELETE /api/testimoials/{id}
	@DeleteMapping("/{id}")
	public String deleteTestimonial(@PathVariable Integer id) {
		testimonialService.deleteTestimonials(id);
		return "Testimnial deleted";
	}
}
