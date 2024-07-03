package com.springFullStackProject.fullStackProject.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springFullStackProject.fullStackProject.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
	
	List <Post> findByUserId(Long userId);
}
