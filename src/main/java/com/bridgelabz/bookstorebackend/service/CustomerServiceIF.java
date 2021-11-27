package com.bridgelabz.bookstorebackend.service;

import com.bridgelabz.bookstorebackend.model.Address;
import com.bridgelabz.bookstorebackend.model.Customer;

import java.util.UUID;

import com.bridgelabz.bookstorebackend.dto.AddressDTO;
import com.bridgelabz.bookstorebackend.dto.LoginDTO;
import com.bridgelabz.bookstorebackend.dto.SignUpDTO;

public interface CustomerServiceIF {

	Customer signUpCustomer(SignUpDTO signUpDTO);

	Customer loginCustomer(LoginDTO loginDTO);

	Customer getCustomerById(UUID customerId);

	Address addAddress(UUID customerId, AddressDTO addressDTO);

	Address updateAddress(UUID customerId, AddressDTO addressDTO);

	Customer getPassword(String email);

}
