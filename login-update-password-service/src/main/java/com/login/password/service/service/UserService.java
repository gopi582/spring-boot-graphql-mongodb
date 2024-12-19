package com.login.password.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.password.service.client.GraphQLClient;
import com.login.password.service.model.UserModel;
import com.login.password.service.model.UserRequest;

@Service
public class UserService {

	@Autowired
	private GraphQLClient graphQLClient;
	
	public List<UserModel> fetchAllUsers(){
		return graphQLClient.fetchAllUsers();
	}
	
	public UserModel getUserById(int id) {
		return graphQLClient.getUserById(id);
	}
	
	public UserModel validateUser(String userId, String password) {
		return graphQLClient.validateUser(userId,password);
	}
	
	public UserModel createUser(UserRequest userRequest) {
		return graphQLClient.createUser(userRequest);
	}

	public UserModel updatePassWord(int id, String password) {
		return graphQLClient.updatePassWord(id,password);
	}
}
