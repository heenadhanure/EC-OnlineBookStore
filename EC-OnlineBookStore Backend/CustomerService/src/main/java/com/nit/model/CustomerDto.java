package com.nit.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Email cannot be blank")
	@Schema(description = "Email",example = "enter the email")
	@Column(name = "email")
	private String email;
	
	@NotBlank(message = "Name cannot be blank")
	@Schema(description = "Name", example = "Enter name")
	@Column(name = "name")
	private String name;
	
}
