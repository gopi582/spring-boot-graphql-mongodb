package com.details.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.details.service.entity.UserEntity;
import com.details.service.service.UserServie;

@Controller
public class UserQuery {

	@Autowired
	private UserServie userServie;

	@QueryMapping
	public List<UserEntity> getAllUsers() {
		return userServie.getAllUsers();
	}
	
	@QueryMapping
	public UserEntity getUserById(@Argument("userId") int userId) {
		return userServie.getUserById(userId);
	}
	
	@QueryMapping
	public UserEntity validateUser(@Argument("userId") String userId, @Argument("password") String password) {
		return userServie.validateUser(userId,password);
	}

}
