package com.nit.model;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class ErrorMessage {
	private Integer statusCode;
	private String status;
	String message;
	List<?> list;
	Map<?,?> map; 
	
	public ErrorMessage(Integer statusCode, String status, String message, List<?> list) {
		super();
		this.statusCode = statusCode;
		this.status = status;
		this.message = message;
		this.list = list;
	}

	public ErrorMessage(Integer statusCode, String status, String message, Map<?,?> map) {
		super();
		this.statusCode = statusCode;
		this.status = status;
		this.message = message;
		this.map = map;
	}
	
	
}
