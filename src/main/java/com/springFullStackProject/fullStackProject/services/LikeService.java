package com.springFullStackProject.fullStackProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springFullStackProject.fullStackProject.entities.Like;
import com.springFullStackProject.fullStackProject.entities.Post;
import com.springFullStackProject.fullStackProject.entities.User;
import com.springFullStackProject.fullStackProject.repos.LikeRepository;
import com.springFullStackProject.fullStackProject.requests.LikeCreateRequest;

@Service
public class LikeService {

	LikeRepository likeRepository;
	UserServices userService;
	PostService postService;

	public LikeService(LikeRepository likeRepository) {
		this.likeRepository = likeRepository;
	}
	
	public List<Like> getAllLikes(Optional<Long> postId, Optional<Long> userId){
		if(postId.isPresent() && userId.isPresent()) {
			return likeRepository.findByPostIdAndUserId(postId, userId);			
		} else if(postId.isPresent()) {
			return likeRepository.findByPostId(postId);
		} else if(userId.isPresent()) {
			return likeRepository.findByUserId(userId);
		} else {
			return likeRepository.findAll();
		}
	}

	public Like createOneLike(LikeCreateRequest likeRequest) {
		User user = userService.getOneUser(likeRequest.getUserId());
		Post post = postService.getOnePost(likeRequest.getPostId());
		if (user != null && post != null) {
			Like likeToSave = new Like();
			likeToSave.setId(likeRequest.getId());
			likeToSave.setUser(user);
			likeToSave.setPost(post);
			return likeRepository.save(likeToSave);
		}
		else return null;
	}

	public Like getOneLike(Long likeId) {
		return likeRepository.findById(likeId).orElse(null);
	}

	public void deleteOneLike(Long likeId) {
		likeRepository.deleteById(likeId);
	}
	
	
}
