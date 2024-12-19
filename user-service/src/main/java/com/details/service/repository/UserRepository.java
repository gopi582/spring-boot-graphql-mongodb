package com.details.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.details.service.entity.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, Integer>{

	UserEntity findByUserId(String userId);

}
