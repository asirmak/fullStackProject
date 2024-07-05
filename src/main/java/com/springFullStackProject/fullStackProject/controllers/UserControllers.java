package com.springFullStackProject.fullStackProject.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springFullStackProject.fullStackProject.entities.User;
import com.springFullStackProject.fullStackProject.responses.UserResponse;
import com.springFullStackProject.fullStackProject.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserControllers {

	private UserServices userServices;

	public UserControllers(UserServices userServices) {
		this.userServices = userServices;
	}
	
	@GetMapping()
	public List<User> getAllUsers(){
		return userServices.getAllUsers();
	}

	@PostMapping()
	public User createUser(@RequestBody User user) {
		return userServices.createUser(user);
	}

	@GetMapping("/{user_id}")
	public UserResponse getOneUser(@PathVariable Long user_id){
		return new UserResponse(userServices.getOneUser(user_id));
	}
	
	@PutMapping("/{user_id}")
	public User updateOneUser(@PathVariable Long user_id, @RequestBody User newUser) {
		return userServices.updateOneUser(user_id, newUser);
	}
	
	@DeleteMapping("/{user_id}")
	public void deleteOneUser(@PathVariable Long user_id) {
		userServices.deleteOneUser(user_id);
	}
	
	@GetMapping("/activity/{user_id}")
	public List<Object> getUserActivity(@PathVariable Long user_id){
		return userServices.getUserActivity(user_id);
	}
	
}
