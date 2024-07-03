package com.springFullStackProject.fullStackProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.springFullStackProject.fullStackProject.entities.User;
import com.springFullStackProject.fullStackProject.repos.UserRepository;

@Service
public class UserServices {

	private UserRepository userRepository;

	public UserServices (UserRepository userRepository) {
		this.userRepository = userRepository;
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
			foundUser.setUserName(newUser.getUserName());
			foundUser.setPassword(newUser.getPassword());
			userRepository.save(foundUser);
			return foundUser;
		}else return null;
	}
	
	public void deleteOneUser(@PathVariable Long user_id) {
		userRepository.deleteById(user_id);
	}
	
}
