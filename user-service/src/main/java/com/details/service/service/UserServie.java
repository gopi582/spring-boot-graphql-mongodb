package com.details.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.details.service.entity.AddressEntity;
import com.details.service.entity.UserEntity;
import com.details.service.model.UserRequest;
import com.details.service.repository.UserRepository;

@Service
public class UserServie {
	
	@Autowired
	private UserRepository userRepository;

	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}

	public UserEntity createUser(UserRequest userRequest) {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(userRequest.getId());
		userEntity.setName(userRequest.getName());
		userEntity.setPassword(userRequest.getPassword());
		userEntity.setUserId(userRequest.getUserId());
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setAddressLine1(userRequest.getAddressRequest().getAddressLine1());
		addressEntity.setPinCode(userRequest.getAddressRequest().getPinCode());
		addressEntity.setStreet(userRequest.getAddressRequest().getStreet());
		userEntity.setAddressEntity(addressEntity);
		return userRepository.save(userEntity);
	}

	public UserEntity getUserById(int userId) {
		return userRepository.findById(userId).get();
	}

	public UserEntity validateUser(String userId, String password) {
		UserEntity userEntity = userRepository.findByUserId(userId);
		if(userId.equalsIgnoreCase(userEntity.getUserId()) && password.equalsIgnoreCase(userEntity.getPassword())) {
			return userEntity;
		}
		return null;
	}

	public UserEntity updatePassword(int id, String password) {
		UserEntity userEntity = userRepository.findById(id).get();
		userEntity.setPassword(password);
		return userRepository.save(userEntity);
	}

}
