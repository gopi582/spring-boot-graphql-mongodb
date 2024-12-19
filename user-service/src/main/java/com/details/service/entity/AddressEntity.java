package com.details.service.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {
	
	@NotBlank
	private String addressLine1;
	
	@NotBlank
	private String street;
	
	@NotBlank
	private String pinCode;
}
