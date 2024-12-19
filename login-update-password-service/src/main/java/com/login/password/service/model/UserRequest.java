package com.login.password.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
	private int id;
	private String name;
	private String userId;
	private String password;
	private AddressRequest addressRequest;
}
