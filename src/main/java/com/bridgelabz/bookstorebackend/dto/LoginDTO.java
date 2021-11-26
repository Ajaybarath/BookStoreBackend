package com.bridgelabz.bookstorebackend.dto;

import javax.validation.constraints.Pattern;

import lombok.Data;

public @Data class LoginDTO {

	@Pattern(regexp = "([a-zA-Z][a-zA-Z0-9]*)(([+_.-][a-zA-Z0-9]+)?)(@[a-zA-Z0-9]+)([.])([a-z]{2,})(([.][a-z]{2})?)", message = "Email Invalid")
	public String email;
	
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.{8,})[0-9a-zA-Z]*[^0-9a-zA-Z][0-9a-zA-Z]*$", message = "Password Invalid")
	public String password;
}
