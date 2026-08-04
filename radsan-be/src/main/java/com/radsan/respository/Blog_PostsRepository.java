package com.radsan.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.radsan.entity.Blog_Posts;



public interface Blog_PostsRepository extends JpaRepository<Blog_Posts,Integer> {

}
