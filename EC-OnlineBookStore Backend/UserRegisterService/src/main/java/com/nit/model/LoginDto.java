package com.nit.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDto {
	
	@NotBlank(message = "email cannot blank")
	private String email;
	
	@NotBlank(message = "password cannot blank")
	private String password;

	public LoginDto(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
