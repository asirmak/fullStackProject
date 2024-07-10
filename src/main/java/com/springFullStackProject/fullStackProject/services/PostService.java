package com.springFullStackProject.fullStackProject.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springFullStackProject.fullStackProject.entities.Post;
import com.springFullStackProject.fullStackProject.entities.User;
import com.springFullStackProject.fullStackProject.repos.PostRepository;
import com.springFullStackProject.fullStackProject.requests.PostCreateRequest;
import com.springFullStackProject.fullStackProject.requests.PostUpdateRequest;
import com.springFullStackProject.fullStackProject.responses.LikeResponse;
import com.springFullStackProject.fullStackProject.responses.PostResponse;

@Service
public class PostService {

	private PostRepository postRepository;
	private LikeService likeService;
	private UserServices userService;
	
	public PostService(PostRepository postRepository, UserServices userService) {
		this.postRepository = postRepository;
		this.userService = userService;
	}
	
	@Autowired
	public void setLikeService(LikeService likeService) {
		this.likeService = likeService;
	}
	
	public List<PostResponse> getAllPosts(Optional <Long> userId){
		List <Post> list;
		List <PostResponse> prList = new ArrayList<PostResponse>();
		if (userId.isPresent()) {
			list = postRepository.findByUserId(userId.get());
		}else {
			list = postRepository.findAll();
		}
		
		ListIterator<Post> iterator = list.listIterator(list.size());
		
		while(iterator.hasPrevious()) {
			Post post = iterator.previous();
			List<LikeResponse> postLikes= likeService.getAllLikes(Optional.of(post.getId()),Optional.ofNullable(null));
			User user = userService.getOneUser(post.getUser().getId());
			
			prList.add(new PostResponse(post, postLikes, user));

		}
		
		return prList;
	}	
	

	public Post getOnePost(Long postId) {
		return postRepository.findById(postId).orElse(null);
	}
	
	public PostResponse getOnePostWithLikes(Long postId) {
		Post post = postRepository.findById(postId).orElse(null);
				
		List<LikeResponse> postLikes= likeService.getAllLikes(Optional.of(postId),Optional.ofNullable(null));
		User user = userService.getOneUser(post.getUser().getId());

		return new PostResponse(post, postLikes, user);
	}

	public Post createOnePost(PostCreateRequest newPostRequest) {
		User user = userService.getOneUser(newPostRequest.getUserId());
		if (user == null) return null;
		Post toSave = new Post();
		toSave.setId(newPostRequest.getId());
		toSave.setText(newPostRequest.getText());
		toSave.setTitle(newPostRequest.getTitle());
		toSave.setCreateDate(new Date());
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
