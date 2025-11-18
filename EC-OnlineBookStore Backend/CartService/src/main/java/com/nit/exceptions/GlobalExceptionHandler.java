package com.nit.exceptions;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nit.model.ErrorMessage;
import com.nit.utility.Constants;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
//	@ExceptionHandler(CustomerIdNotFoundException.class)
//	public ResponseEntity<Object> custmerHandleException(CustomerIdNotFoundException ex) {
//		List<String> details = new ArrayList<>();
//		details.add("Error : Customer Id not found");
//		details.add("Detailed Message:" + ex.getLocalizedMessage());
//		details.add("Timestamp:" + System.currentTimeMillis());
//		ErrorMessage error = new ErrorMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constants.FAILURE, "Customer Id Not Found",details);
//		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//
//	}
	
	@ExceptionHandler(InternalServerErrorException.class)
	public ResponseEntity<Object> internalServerException(InternalServerErrorException ex){
		Map<String, Object> hm = new HashMap<>();
		hm.put("Error Message :", "Internal Server Error");
		hm.put("Detailed Message : ", ex.getLocalizedMessage());
		hm.put("Timestamp :", System.currentTimeMillis());
		
		ErrorMessage error = new ErrorMessage(HttpURLConnection.HTTP_INTERNAL_ERROR, Constants.FAILED, "Internal Servcer Error", hm );
		
		return ResponseEntity.ok(error);
	}

}

