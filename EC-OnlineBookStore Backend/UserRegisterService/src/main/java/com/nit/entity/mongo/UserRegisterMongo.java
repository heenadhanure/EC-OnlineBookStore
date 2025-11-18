package com.nit.entity.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Data;

@Document(collection="user_registers")
@Data
public class UserRegisterMongo {
	
	@Id
	private String id;
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private long contactId;
}
