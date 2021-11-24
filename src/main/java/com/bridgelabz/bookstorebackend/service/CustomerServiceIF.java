package com.bridgelabz.bookstorebackend.service;

import com.bridgelabz.bookstorebackend.data.AddressData;
import com.bridgelabz.bookstorebackend.data.CustomerData;
import com.bridgelabz.bookstorebackend.dto.AddressDTO;
import com.bridgelabz.bookstorebackend.dto.LoginDTO;
import com.bridgelabz.bookstorebackend.dto.SignUpDTO;

public interface CustomerServiceIF {

	CustomerData signUpCustomer(SignUpDTO signUpDTO);
	
	CustomerData loginCustomer(LoginDTO loginDTO);

	AddressData addAddress(int customerId, AddressDTO addressDTO);
}
