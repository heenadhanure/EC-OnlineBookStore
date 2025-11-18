package com.nit.exceptions;

public class UserIdNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public UserIdNotFoundException (String msg) {
		
		super(msg);
	}

}
