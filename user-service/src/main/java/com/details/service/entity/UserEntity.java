package com.details.service.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "UserData")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
	
	@Id
	private int id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String userId;
	
	@NotBlank
	private String password;
	
	private AddressEntity addressEntity;

}
