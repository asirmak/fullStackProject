package com.springFullStackProject.fullStackProject.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springFullStackProject.fullStackProject.entities.Comment;
import com.springFullStackProject.fullStackProject.requests.CommentCreateRequest;
import com.springFullStackProject.fullStackProject.requests.CommentUpdateRequest;
import com.springFullStackProject.fullStackProject.responses.CommentResponse;
import com.springFullStackProject.fullStackProject.services.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

	private CommentService commentService;

	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@GetMapping()
	public List<CommentResponse> getAllComments(@RequestParam Optional<Long> userId, 
			@RequestParam Optional<Long> postId){
		return commentService.getAllComments(userId, postId);
	}
	
	@PostMapping()
	public Comment createOneComment(@RequestBody CommentCreateRequest commentRequest) {
		return commentService.createOneComment(commentRequest);
	}
	
	@GetMapping("/{commentId}")
	public Comment getOneComment(@PathVariable Long commentId) {
		return commentService.getOneComment(commentId);
	}
	
	@PutMapping("/{commentId}")
	public Comment updateOneComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest updatedComment) {
		return commentService.updateOneComment(commentId, updatedComment);
	}
	
	@DeleteMapping("/{commentId}")
	public void deleteOneComment(@PathVariable Long commentId) {
		commentService.deleteOneComment(commentId);
	}
	
	
}
