package com.nit.exceptions;

public class InternalServerErrorException extends RuntimeException {
	private static final long serialVerionId = 1L;

	public InternalServerErrorException(String msg) {
		super(msg);
	}
}
