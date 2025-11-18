package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Book;
import com.nit.entity.Cart;
import com.nit.entity.Customer;

public interface CartRepo extends JpaRepository<Cart, Long>{

	Cart findByCustomerAndBook(Customer customer, Book book);

}
