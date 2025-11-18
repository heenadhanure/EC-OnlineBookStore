package com.nit.exceptions;

public class BookNotFoundException extends RuntimeException {
	public static final Long serialVersionId = 1L;
	
	public BookNotFoundException(String msg) {
		super(msg);
	}
}
