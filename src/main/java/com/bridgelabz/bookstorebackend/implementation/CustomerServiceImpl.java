package com.bridgelabz.bookstorebackend.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.bookstorebackend.model.Address;
import com.bridgelabz.bookstorebackend.model.User;
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
	public User signUpCustomer(SignUpDTO signUpDTO) {
		User userData = new User(signUpDTO);
		return customerRepository.save(userData);
	}

	@Override
	public User loginCustomer(LoginDTO loginDTO) {
		return customerRepository.loginCustomer(loginDTO.getEmail(), loginDTO.getPassword());
	}

	@Override
	public User getPassword(String email) {
		return customerRepository.getPassword(email);
	}

	@Override
	public User getCustomerById(int customerId) {
		return customerRepository.findById(customerId).orElseThrow(() -> new BooksException("Customer Not Found"));
	}

	public Address getAddressById(int customerId, String addressType) {
		return addressRepository.getAddress(customerId, addressType);
	}

	@Override
	public Address addAddress(int customerId, AddressDTO addressDTO) {
		Address addressData = new Address(customerId, addressDTO);
		return addressRepository.save(addressData);
	}

	@Override
	public Address updateAddress(int customerId, AddressDTO addressDTO) {
		Address addressData = this.getAddressById(customerId, addressDTO.getAddressType());
		addressData.updateAddress(customerId, addressDTO);
		return addressRepository.save(addressData);
	}

}
