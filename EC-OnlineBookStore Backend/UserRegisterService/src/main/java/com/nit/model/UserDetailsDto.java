package com.nit.model;

import lombok.Data;

@Data
public class UserDetailsDto {
	
	public UserDetailsDto() {
		
	}

	private Long id;
	private String firstName;
	private String lastName;
	private String email;

	
	public UserDetailsDto(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


}

