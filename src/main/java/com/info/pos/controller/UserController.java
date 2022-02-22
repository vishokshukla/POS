package com.info.pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.pos.entity.User;
import com.info.pos.service.POSService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private POSService posService;
	
	@GetMapping("/user")
	public List<User> getUsers() {
		return posService.getUsers();
	}
	
	@GetMapping("/user/{userId}")
	public User getUser(@PathVariable String userId) {
		User user = posService.getUser(userId);
		if(user == null)
			throw new RuntimeException("User not found : " + userId);
		return user;
	}
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		user.setUserId(null);
		posService.saveUser(user);
		return user;
	}
	
	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		posService.saveUser(user);
		return user;
	}
	
	@DeleteMapping("/user/{userId}")
	public String deleteUser(@PathVariable String userId) {
		User user = posService.getUser(userId);
		if(user == null)
			throw new RuntimeException("User not found" + userId);
		posService.deleteUser(userId);
		return "User deleted";
	}
}
