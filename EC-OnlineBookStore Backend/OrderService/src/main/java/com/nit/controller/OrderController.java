package com.nit.controller;

import java.net.HttpURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.Orders;
import com.nit.model.OrderDto;
import com.nit.model.ResponseMessage;
import com.nit.service.OrderService;
import com.nit.utility.Constants;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/placeorder")
	public ResponseEntity<ResponseMessage> placeOrder(@RequestBody OrderDto orderDto){
		try {
			// 1. Call the service layer to handle order creation logic
			// the service method (saveOrders) will validate, check prime status, and save the order
			String saveOrders = orderService.saveOrders(orderDto);
			
			// 2. Check if the returned message from service indicates success 
			// using contains("success") to detect a successful message from the service layer
			if(saveOrders.toLowerCase().contains("success")) {
				
				// 3. Return a success response to the client
				return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constants.SUCCESS, "Order Placed Successfully", saveOrders));
			}else {
				// 4. If service returned a failure message, send a bad request response
				return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constants.FAILED, "Order Placement Failed", saveOrders));				
			}
		}catch(Exception e) {
			// 5. In case of any unexpected exceptions, log and return an interval error response
			e.printStackTrace();
			return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_INTERNAL_ERROR, Constants.FAILED, "Internal Server Error"));							
		}
	}
	
	@GetMapping("/getorderbycustomer/{customerId}")
	public ResponseEntity<ResponseMessage> getOrderByCustomer(@PathVariable Long customerId){
		Orders getOrderByCustomerId =  orderService.getOrderByCustomerId(customerId);
		if(getOrderByCustomerId != null) {
			return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constants.SUCCESS, "Order Fetche Successfully", getOrderByCustomerId));
		}else {
			return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constants.FAILED, "Order Fetching Failed", getOrderByCustomerId));				
		}
	}
	
}
