package com.bridgelabz.bookstorebackend.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

public @Data class AddressDTO {

	@Pattern(regexp = "([a-zA-Z]{3,}\\s?){2,}$", message = "Address is Invalid")
	public String address;
	
	@NotBlank(message = "City Cannot be Empty")
	public String city;
	
	@NotBlank(message = "State Cannot be Empty")
	public String state;
	
	@NotNull(message= "Address Type Should Not be Empty")
	public String addressType;
}
