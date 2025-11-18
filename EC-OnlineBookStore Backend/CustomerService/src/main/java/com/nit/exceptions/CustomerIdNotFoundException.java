package com.nit.exceptions;

public class CustomerIdNotFoundException extends RuntimeException{
	private static final long serialVerionId = 1L;
	
	public CustomerIdNotFoundException(String msg) {
		super(msg);
	}
}
