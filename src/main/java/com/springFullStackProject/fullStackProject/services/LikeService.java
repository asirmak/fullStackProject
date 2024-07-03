package com.springFullStackProject.fullStackProject.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springFullStackProject.fullStackProject.entities.Like;
import com.springFullStackProject.fullStackProject.entities.Post;
import com.springFullStackProject.fullStackProject.entities.User;
import com.springFullStackProject.fullStackProject.repos.LikeRepository;
import com.springFullStackProject.fullStackProject.requests.LikeCreateRequest;
import com.springFullStackProject.fullStackProject.responses.LikeResponse;

@Service
public class LikeService {

	LikeRepository likeRepository;
	UserServices userService;
	PostService postService;

	public LikeService(LikeRepository likeRepository, UserServices userService, PostService postService) {
		this.likeRepository = likeRepository;
		this.userService = userService;
		this.postService = postService;
	}
	
	public List<LikeResponse> getAllLikes(Optional<Long> postId, Optional<Long> userId){
		List <Like> list;
		if(postId.isPresent() && userId.isPresent()) {
			list = likeRepository.findByPostIdAndUserId(postId, userId);			
		} else if(postId.isPresent()) {
			list = likeRepository.findByPostId(postId);
		} else if(userId.isPresent()) {
			list = likeRepository.findByUserId(userId);
		} else {
			list = likeRepository.findAll();
		}
		return list.stream().map(like -> new LikeResponse(like)).collect(Collectors.toList());
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
