package com.bridgelabz.bookstorebackend.service;

import com.bridgelabz.bookstorebackend.model.Address;
import com.bridgelabz.bookstorebackend.model.Customer;
import com.bridgelabz.bookstorebackend.dto.AddressDTO;
import com.bridgelabz.bookstorebackend.dto.LoginDTO;
import com.bridgelabz.bookstorebackend.dto.SignUpDTO;

public interface CustomerServiceIF {

	Customer signUpCustomer(SignUpDTO signUpDTO);

	Customer loginCustomer(LoginDTO loginDTO);

	Customer getCustomerById(int customerId);

	Address addAddress(int customerId, AddressDTO addressDTO);

	Address updateAddress(int customerId, AddressDTO addressDTO);

}
