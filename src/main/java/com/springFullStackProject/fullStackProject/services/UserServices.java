package com.springFullStackProject.fullStackProject.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.springFullStackProject.fullStackProject.entities.User;
import com.springFullStackProject.fullStackProject.repos.CommentRepository;
import com.springFullStackProject.fullStackProject.repos.LikeRepository;
import com.springFullStackProject.fullStackProject.repos.PostRepository;
import com.springFullStackProject.fullStackProject.repos.UserRepository;

@Service
public class UserServices {

	private UserRepository userRepository;
	private LikeRepository likeRepository;
	private CommentRepository commentRepository;
	private PostRepository postRepository;
	
	public UserServices(UserRepository userRepository, LikeRepository likeRepository,
			CommentRepository commentRepository, PostRepository postRepository) {
		this.userRepository = userRepository;
		this.likeRepository = likeRepository;
		this.commentRepository = commentRepository;
		this.postRepository = postRepository;
	}

	public List<User> getAllUsers(){
		return userRepository.findAll();
	}

	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	public User getOneUser(@PathVariable Long user_id){
		return userRepository.findById(user_id).orElse(null);
	}
	
	public User updateOneUser(@PathVariable Long user_id, @RequestBody User newUser) {
		Optional<User> user = userRepository.findById(user_id);
		
		if (user.isPresent()){
			User foundUser = user.get();
			if(newUser.getUserName() != null) foundUser.setUserName(newUser.getUserName());
			if(newUser.getPassword() != null) foundUser.setPassword(newUser.getPassword());
			if(newUser.getAvatar() != 0) foundUser.setAvatar(newUser.getAvatar());
			userRepository.save(foundUser);
			return foundUser;
		}else return null;
	}
	
	public void deleteOneUser(@PathVariable Long user_id) {
		userRepository.deleteById(user_id);
	}

	public User getOneUserByUserName(String username) {
		return userRepository.findByUserName(username);
	}

	public List<Object> getUserActivity(Long user_id) {
		
		List <Long> postIds = postRepository.findTopByUserId(user_id);
		if (postIds.isEmpty()) {
			return null;
		}
		List<Object> comments = commentRepository.findUserCommentsByPostId(postIds);
		List<Object> likes = likeRepository.findUserLikesByPostId(postIds);
		List<Object> result = new ArrayList<>();
		result.addAll(comments);
		result.addAll(likes);
		return result;
	}
	
}
