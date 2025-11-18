package com.nit.service;

import com.nit.entity.Orders;
import com.nit.model.OrderDto;

public interface OrderService {

	String saveOrders(OrderDto orderDto);

	Orders getOrderByCustomerId(Long customerId);

}
