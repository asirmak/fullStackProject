package com.springFullStackProject.fullStackProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springFullStackProject.fullStackProject.entities.Post;
import com.springFullStackProject.fullStackProject.entities.User;
import com.springFullStackProject.fullStackProject.repos.PostRepository;
import com.springFullStackProject.fullStackProject.requests.PostCreateRequest;
import com.springFullStackProject.fullStackProject.requests.PostUpdateRequest;

@Service
public class PostService {

	private PostRepository postRepository;
	private UserServices userService;
	
	public PostService(PostRepository postRepository, UserServices userService) {
		this.postRepository = postRepository;
		this.userService = userService;
	}
	
	public List<Post> getAllPosts(Optional <Long> userId){
		if (userId.isPresent()) {
			return postRepository.findByUserId(userId.get());
		}else {
			return postRepository.findAll();
		}
	}

	public Post getOnePost(Long postId) {
		return postRepository.findById(postId).orElse(null);
	}

	public Post createOnePost(PostCreateRequest newPostRequest) {
		User user = userService.getOneUser(newPostRequest.getUserId());
		if (user == null) return null;
		Post toSave = new Post();
		toSave.setId(newPostRequest.getId());
		toSave.setText(newPostRequest.getText());
		toSave.setTitle(newPostRequest.getTitle());
		toSave.setUser(user);
		return postRepository.save(toSave);
	}

	public Post updateOnePost(Long postId, PostUpdateRequest updatePost) {
		Optional<Post> post = postRepository.findById(postId);
		if (post.isPresent()) {
			Post toUpdate = post.get();
			toUpdate.setText(updatePost.getText());
			toUpdate.setTitle(updatePost.getTitle());
			postRepository.save(toUpdate);
			return toUpdate;
		}
		return null;
	}

	public void deleteOnePost(Long postId) {
		postRepository.deleteById(postId);;
	}
}
