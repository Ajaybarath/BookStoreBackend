package com.bridgelabz.bookstorebackend.implementation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.bookstorebackend.model.Address;
import com.bridgelabz.bookstorebackend.model.Customer;
import com.bridgelabz.bookstorebackend.dto.AddressDTO;
import com.bridgelabz.bookstorebackend.dto.LoginDTO;
import com.bridgelabz.bookstorebackend.dto.SignUpDTO;
import com.bridgelabz.bookstorebackend.exception.BooksException;
import com.bridgelabz.bookstorebackend.repository.AddressRepository;
import com.bridgelabz.bookstorebackend.repository.CustomerRepository;
import com.bridgelabz.bookstorebackend.service.CustomerServiceIF;

@Service
public class CustomerServiceImpl implements CustomerServiceIF {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AddressRepository addressRepository;

	@Override
	public Customer signUpCustomer(SignUpDTO signUpDTO) {
		Customer customerData = new Customer(signUpDTO);
		return customerRepository.save(customerData);
	}

	@Override
	public Customer loginCustomer(LoginDTO loginDTO) {
		return customerRepository.loginCustomer(loginDTO.getEmail(), loginDTO.getPassword());
	}

	@Override
	public Customer getPassword(String email) {
		return customerRepository.getPassword(email);
	}

	@Override
	public Customer getCustomerById(UUID customerId) {
		return customerRepository.findById(customerId).orElseThrow(() -> new BooksException("Customer Not Found"));
	}

	public Address getAddressById(UUID customerId, String addressType) {
		return addressRepository.getAddress(customerId, addressType);
	}

	@Override
	public Address addAddress(UUID customerId, AddressDTO addressDTO) {
		Address addressData = new Address(customerId, addressDTO);
		return addressRepository.save(addressData);
	}

	@Override
	public Address updateAddress(UUID customerId, AddressDTO addressDTO) {
		Address addressData = this.getAddressById(customerId, addressDTO.getAddressType());
		System.out.println(addressData);
		addressData.updateAddress(customerId, addressDTO);
		return addressRepository.save(addressData);
	}

}
