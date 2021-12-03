package com.bridgelabz.bookstorebackend.dto;

import javax.validation.constraints.Pattern;

import lombok.Data;

public @Data class SignUpDTO {

	@Pattern(regexp = "^[A-Z]{1}[a-zA_Z\\s]{2,}$", message = "Customer Name Invalid")
	public String fullName;

	@Pattern(regexp = "^([+]?[1-9][0-9])?[0-9]{10}$", message = "Phone Number Invalid")
	public String phoneNumber;

	@Pattern(regexp = "([a-zA-Z][a-zA-Z0-9]*)(([+_.-][a-zA-Z0-9]+)?)(@[a-zA-Z0-9]+)([.])([a-z]{2,})(([.][a-z]{2})?)", message = "Email Invalid")
	public String email;

	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.{8,})[0-9a-zA-Z]*[^0-9a-zA-Z][0-9a-zA-Z]*$", message = "Password Invalid")
	public String password;
}
