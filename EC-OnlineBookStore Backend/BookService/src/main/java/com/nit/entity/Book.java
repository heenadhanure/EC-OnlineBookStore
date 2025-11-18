package com.nit.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	
	@Column(name = "bookTitle")
	private String bookTitle;
	
	@Column(name = "bookAuthor")
	private String bookAuthor;
	
	@Column(name = "bookPublisher")
	private String bookPublisher;
	
	@Column(name = "bookPrice")
	private Double bookPrice;
	
	@CreationTimestamp
	@Column(name = "createdDate")
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(name = "updatedDate")
	private LocalDate updatedDate;
	
}
