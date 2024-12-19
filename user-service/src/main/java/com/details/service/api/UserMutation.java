package com.details.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.details.service.entity.UserEntity;
import com.details.service.model.UserRequest;
import com.details.service.service.UserServie;

@Controller
public class UserMutation {
	
	@Autowired
	private UserServie userServie;
	
	@MutationMapping
	public UserEntity createUser(@Argument("userRequest") UserRequest userRequest) {
		return userServie.createUser(userRequest);
	}
	
	@MutationMapping
	public UserEntity updatePassWord(@Argument("id") int id, @Argument("password") String password) {
		return userServie.updatePassword(id,password);
		
	}

}
