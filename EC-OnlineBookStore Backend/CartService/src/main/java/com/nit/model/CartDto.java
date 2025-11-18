package com.nit.model;

import com.nit.entity.Book;
import com.nit.entity.Customer;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class CartDto {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int quantity;
	private double totalPrice;
	
	@ManyToOne
	@JoinColumn(name = "customerId",updatable = false)
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "bookId",updatable = false)
	private Book book;

	public CartDto(int quantity, Book book, Customer customer) {
		super();
		this.quantity = quantity;
		this.book = book;
		this.customer = customer;
	}
	
}
