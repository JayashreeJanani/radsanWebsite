package com.radsan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.radsan.entity.Blog_Posts;
import com.radsan.respository.Blog_PostsRepository;

@Service

public class Blog_PostsService {
	private final Blog_PostsRepository blogRepository;
	
	public Blog_PostsService(Blog_PostsRepository blogRepository) {
		this.blogRepository = blogRepository;
	}
//for api: GET /api/blogs
	public List<Blog_Posts> getAllBlogs(){
		return blogRepository.findAll();
		
	}
//for api: GET /api/blogs/{id}
	public Blog_Posts getBlogById(Integer id) {
	    return blogRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Blog not found with id: " + id));
	}
//for api: POST /api/blogs
	public Blog_Posts createBlogs(Blog_Posts blogPosts) {
		return blogRepository.save(blogPosts);
		
	}
//for api: PUT /api/blogs/{id}
	public Blog_Posts updateBlogs(Integer id,Blog_Posts updatedBlogs) {
		Blog_Posts blog_posts = blogRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Blog not found"));
		blog_posts.setTitle(blog_posts.getTitle());
		blog_posts.setSlug(blog_posts.getSlug());
		blog_posts.setContent(blog_posts.getContent());
		blog_posts.setIsPublished(blog_posts.getIsPublished());
		blog_posts.setPublishedAt(blog_posts.getPublishedAt());
		
		return blogRepository.save(blog_posts);
	}
//for api: DELETE /api/blogs/{id}
	public void deleteBlogs(Integer id) {
		Blog_Posts blog_posts = blogRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Blog not found"));
		 blogRepository.delete(blog_posts);
	}
}
