package com.bridgelabz.bookstorebackend.service;

import com.bridgelabz.bookstorebackend.model.Address;
import com.bridgelabz.bookstorebackend.model.User;
import com.bridgelabz.bookstorebackend.dto.AddressDTO;
import com.bridgelabz.bookstorebackend.dto.LoginDTO;
import com.bridgelabz.bookstorebackend.dto.SignUpDTO;

public interface CustomerServiceIF {

	User signUpCustomer(SignUpDTO signUpDTO);

	User loginCustomer(LoginDTO loginDTO);

	User getCustomerById(int customerId);

	Address addAddress(int customerId, AddressDTO addressDTO);

	Address updateAddress(int customerId, AddressDTO addressDTO);

	User getPassword(String email);

}
