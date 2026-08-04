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

import com.radsan.entity.Blog_Posts;
import com.radsan.service.Blog_PostsService;

@RestController
@RequestMapping("/api/blogs")
public class Blog_PostsController {
	private final Blog_PostsService blogService;
	public Blog_PostsController(Blog_PostsService blogService) {
		this.blogService = blogService;
	}
	//for api: GET /api/blogs	
	@GetMapping
	public List<Blog_Posts> getBlogs(){
		return blogService.getAllBlogs();
	}
	//for api: GET /api/blogs/{id}
	@GetMapping("/{id}")
	public Blog_Posts getBlogsById(@PathVariable Integer id) {
		return blogService.getBlogById(id);
	}
	
	//for api: POST /api/blogs
	@PostMapping
	public Blog_Posts createBlogs(@RequestBody Blog_Posts blogPosts) {
		return blogService.createBlogs(blogPosts);
	}
	//for api: PUT /api/blogs/{id}
	@PutMapping("/{id}")
	public Blog_Posts updateBlogs(@PathVariable Integer id, @RequestBody Blog_Posts blogPosts) {
		return blogService.updateBlogs(id, blogPosts);
	}
	//for api: DELETE /api/blogs/{id}
	@DeleteMapping("/{id}")
	public String deleteBlog(@PathVariable Integer id) {
		blogService.deleteBlogs(id);
		
		return "This blog got deleted";
	}
	
	
	

}
