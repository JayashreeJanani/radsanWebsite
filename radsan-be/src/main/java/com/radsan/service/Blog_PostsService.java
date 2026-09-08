package com.radsan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.radsan.dto.Blog_postsRequestDTO;
import com.radsan.dto.Blog_postsResponseDTO;
import com.radsan.entity.Blog_Posts;
import com.radsan.exception.ResourceAlreadyExistsException;
import com.radsan.exception.ResourceNotFoundException;
import com.radsan.respository.Blog_PostsRepository;

@Service

public class Blog_PostsService {
	private final Blog_PostsRepository blogRepository;
	
	public Blog_PostsService(Blog_PostsRepository blogRepository) {
		this.blogRepository = blogRepository;
	}
//for api: GET /api/blogs
	public List<Blog_postsResponseDTO> getAllBlogs(){
		return blogRepository.findAll()
				.stream()
				.map(blog -> new Blog_postsResponseDTO(
						blog.getId(),
						blog.getTitle(),
						blog.getSlug(),
						blog.getContent(),
						blog.getIsPublished(),
						blog.getPublishedAt()
						)).toList();
		
	}
//for api: GET /api/blogs/{id}
	public Blog_postsResponseDTO getBlogById(Integer id) {
	    Blog_Posts blogs = blogRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Blog not found with id: " + id));
	    Blog_postsResponseDTO blogResponseDTO = new Blog_postsResponseDTO();
	    blogResponseDTO.setId(blogs.getId());
	    blogResponseDTO.setTitle(blogs.getTitle());
	    blogResponseDTO.setSlug(blogs.getSlug());
	    blogResponseDTO.setContent(blogs.getContent());
	    blogResponseDTO.setIsPublished(blogs.getIsPublished());
	    blogResponseDTO.setPublishedAt(blogs.getPublishedAt());
	    
	    return blogResponseDTO;
	}
//for api: POST /api/blogs
	public Blog_postsResponseDTO createBlogs(Blog_postsRequestDTO blogPostsRequestDTO) {
		
		if (blogRepository.existsBySlug(blogPostsRequestDTO.getSlug())) {
	        throw new ResourceAlreadyExistsException(
	                "Blog already exists with slug: "
	                + blogPostsRequestDTO.getSlug()
	        );
	    }
		
		Blog_Posts blog_posts = new Blog_Posts();
		blog_posts.setTitle(blogPostsRequestDTO.getTitle());
		blog_posts.setSlug(blogPostsRequestDTO.getSlug());
		blog_posts.setContent(blogPostsRequestDTO.getContent());
		blog_posts.setIsPublished(blogPostsRequestDTO.getIsPublished());
		
		
		Blog_Posts savedPosts =  blogRepository.save(blog_posts);
		Blog_postsResponseDTO responseDTO = new Blog_postsResponseDTO();
		responseDTO.setId(savedPosts.getId());
		
		responseDTO.setTitle(savedPosts.getTitle());
		responseDTO.setSlug(savedPosts.getSlug());
		responseDTO.setContent(savedPosts.getContent());
		responseDTO.setIsPublished(savedPosts.getIsPublished());
		responseDTO.setPublishedAt(savedPosts.getPublishedAt());
		
		return responseDTO;
		
		
		
		
	}
//for api: PUT /api/blogs/{id}
	public Blog_postsResponseDTO updateBlogs(Integer id,Blog_postsRequestDTO updatedBlogs) {
		Blog_Posts blog_posts = blogRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Blog not found"));
		blog_posts.setTitle(blog_posts.getTitle());
		blog_posts.setSlug(blog_posts.getSlug());
		blog_posts.setContent(blog_posts.getContent());
		blog_posts.setIsPublished(blog_posts.getIsPublished());
		
		
		Blog_Posts updatedPosts = blogRepository.save(blog_posts);
		Blog_postsResponseDTO updatedResponseDTO = new Blog_postsResponseDTO();
		updatedResponseDTO.setId(updatedPosts.getId());
		updatedResponseDTO.setTitle(updatedPosts.getTitle());
		updatedResponseDTO.setSlug(updatedPosts.getSlug());
		updatedResponseDTO.setContent(updatedPosts.getContent());
		updatedResponseDTO.setIsPublished(updatedPosts.getIsPublished());
		updatedResponseDTO.setPublishedAt(updatedPosts.getPublishedAt());
		
		return updatedResponseDTO;
	}
//for api: DELETE /api/blogs/{id}
	public void deleteBlogs(Integer id) {
		Blog_Posts blog_posts = blogRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Blog not found"));
		 blogRepository.delete(blog_posts);
	}
}
