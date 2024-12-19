package com.login.password.service.model;


import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class UserModel {
	private int id;
	private String name;
	private String userId;
	private String password;
	private AddressEntity addressEntity;
}
