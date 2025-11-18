package com.nit.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	
	public Cart(Customer customer, Book book, int quantity) {
		super();
		this.customer = customer;
		this.book = book;
		this.quantity = quantity;
	}

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
	
	@CreationTimestamp
	@Column(name = "createdDate")
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
	@Column(name = "updatedDate")
	private LocalDateTime updatedDate;
	
}
