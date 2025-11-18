package com.nit.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BookDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	
	@NotBlank(message = "Book Title cannot be blank")
	@Schema(description = "Book Title",example = "enter the book title")
	@Column(name = "bookTitle")
	private String bookTitle;
	
	@NotBlank(message = "Book Author cannot be blank")
	@Schema(description = "Book Author", example = "Enter book author name")
	@Column(name = "bookAuthor")
	private String bookAuthor;
	
	@NotBlank(message = "Book Price cannot be blank")
	@Schema(description = "Book Price", example = "Enter book price")
	@Column(name = "bookPrice")
	private Double bookPrice;

	@Column
	private String bookPublisher;
}
