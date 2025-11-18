package com.nit.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nit.entity.Customer;
import com.nit.entity.mongo.CustomerMongo;
import com.nit.exceptions.CustomerIdNotFoundException;
import com.nit.model.CustomerDto;
import com.nit.repository.CustomerRepo;
import com.nit.repository.mongo.CustomerMongoRepo;
import com.nit.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	public static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	CustomerMongoRepo customerMongoRepo;
	
	@Override
	public Customer saveCustomer(CustomerDto customerDto) {
		Customer customer = new Customer();
		CustomerMongo customerMongo = new CustomerMongo();
		
		logger.info("CustomerServiceImpl saveCustomer() started");
		if(customerDto.getId() == null) {
			customer.setEmail(customerDto.getEmail());
			customer.setName(customerDto.getName());
			customerRepo.save(customer);
			
			customerMongo.setEmail(customerDto.getEmail());
			customerMongo.setName(customerDto.getName());
			customerMongoRepo.save(customerMongo);
			
			logger.info("CustomerServiceImpl saveCustomer() ended");
		}
		return customer;
	}

	@Override
	public Customer updateCustomer(Long id, Customer customer) {
		logger.info("CustomerServiceImpl updateCustomer() started");
		Customer customer1 = customerRepo.findById(id)
												.orElseThrow(()-> new RuntimeException("Invalid id"));
		if(customer1 != null) {
			customer1.setEmail(customer.getEmail());
			customer1.setName(customer.getName());
			
			logger.info("CustomerServiceImpl updated SUCCESS");
			customerRepo.save(customer1);
		}
		
		logger.info("CustomerServiceImpl updateCustomer() ended");
		return null;
	}

	@Override
	public Customer updateOrSaveCustomer(Customer customer) {
		logger.info("CustomerServiceImpl updateOrSaveCustomer() started");
		if (customer.getId() == null) {
			logger.info("CustomerServiceImpl updateOrSaveCustomer() ==> Customer save SUCCESS");
			
			customerRepo.save(customer);

		} else {

			Optional<Customer> byId = customerRepo.findById(customer.getId());
			if (byId.isPresent()) {
				Customer existData = byId.get();
				existData.setName(customer.getName());
				existData.setEmail(customer.getEmail());
				customerRepo.save(existData);
				logger.info("CustomerServiceImpl updateOrSaveCustomer() ==> Customer update SUCCESS");

			} else {
				logger.error("CustomerServiceImpl updateOrSaveCustomer() FAILED : Customer Id Not Found");
				throw new RuntimeException("Custmer Not Found");
			}
		}
		logger.info("CustomerServiceImpl updateOrSaveCustomer() ended");
		return customer;
	}

	@Override
	public Customer getById(Long id) {
		logger.info("CustomerServiceImpl getById() started");
		Optional<Customer> getById = customerRepo.findById(id);
		if(!getById.isPresent()) {
			logger.error("CustomerServiceImpl getById() : Customer Id Not Found");
			logger.warn("CustomerServiceImpl getById() : Try with another Customer id");
			throw new CustomerIdNotFoundException("Id not found");
		}
		logger.info("CustomerServiceImpl getById() ended");
		return getById.get();
	}

	@Override
	public List<Customer> getAllCustomers() {
		logger.info("CustomerServiceImpl getAllCustomers() started");
		List<Customer> getAll = customerRepo.findAll();
		 // Call Book Service using Feign
		logger.info("CustomerServiceImpl getAllCustomers() ended");
		return getAll;
	}

	@Override
	public Page<Customer> byAllCustomerWithPaginations(int page, int size, String sortField, String pageDir) {
		logger.info("CustomerServiceImpl byAllCustomerWithPaginations() started");
		Sort sort = pageDir.equalsIgnoreCase("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
		PageRequest request = PageRequest.of(page, size, sort);
		logger.info("CustomerServiceImpl byAllCustomerWithPaginations() ended");
		return customerRepo.findAll(request);
	}
		
}
