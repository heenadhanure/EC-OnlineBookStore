package com.nit.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nit.entity.Customer;
import com.nit.model.CustomerDto;

public interface CustomerService {

	Customer saveCustomer(CustomerDto customerDto);

	Customer updateCustomer(Long id, Customer customer);

	Customer updateOrSaveCustomer(Customer customer);

	Customer getById(Long id);

	List<Customer> getAllCustomers();

	Page<Customer> byAllCustomerWithPaginations(int page, int size, String sortField, String pageDir);

}
