package com.login.password.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.password.service.model.UserModel;
import com.login.password.service.model.UserRequest;
import com.login.password.service.service.UserService;

@RestController
@RequestMapping("/user/graphql")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/fetchAllUsers")
	public List<UserModel> fetchAllUsers(){
		return userService.fetchAllUsers();
	}

	@GetMapping("/getUserById/{id}")
	public UserModel getUserById(@PathVariable("id") int id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/validateUser/{userId}/{password}")
	public UserModel validateUser(@PathVariable("userId") String userId,@PathVariable("password") String password) {
		return userService.validateUser(userId,password);
	}
	
	@PostMapping("/createUser")
	public UserModel createUser(@RequestBody UserRequest userRequest) {
		return userService.createUser(userRequest);
	}
	
	@PostMapping("/updatePassWord/{id}/{password}")
	public UserModel updatePassWord(@PathVariable("id") int id,@PathVariable("password") String password) {
		return userService.updatePassWord(id,password);
	}
}
