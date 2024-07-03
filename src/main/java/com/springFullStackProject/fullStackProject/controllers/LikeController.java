package com.springFullStackProject.fullStackProject.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springFullStackProject.fullStackProject.entities.Like;
import com.springFullStackProject.fullStackProject.requests.LikeCreateRequest;
import com.springFullStackProject.fullStackProject.responses.LikeResponse;
import com.springFullStackProject.fullStackProject.services.LikeService;

@RestController
@RequestMapping("/likes")
public class LikeController {

	LikeService likeService;

	public LikeController(LikeService likeService) {
		this.likeService = likeService;
	}

	@GetMapping()
	public List<LikeResponse> getAllLikes(@RequestParam Optional<Long> postId, @RequestParam Optional<Long> userId){
		return likeService.getAllLikes(postId, userId);
	}
	
	@PostMapping()
	public Like createOneLike(@RequestBody LikeCreateRequest likeRequest) {
		return likeService.createOneLike(likeRequest);
	}
	
	@GetMapping("/{likeId}")
	public Like getOneLike(@PathVariable Long likeId) {
		return likeService.getOneLike(likeId);
	}
	
	@DeleteMapping("/{likeId}")
	public void deleteOneLike(@PathVariable Long likeId) {
		likeService.deleteOneLike(likeId);
	}
}
