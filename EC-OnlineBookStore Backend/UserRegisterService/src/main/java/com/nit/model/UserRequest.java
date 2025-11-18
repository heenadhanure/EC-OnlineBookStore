package com.nit.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequest {
	
	public UserRequest() {

	}
	
	private String firstName;
	private String lastName;
	private String email;

}
