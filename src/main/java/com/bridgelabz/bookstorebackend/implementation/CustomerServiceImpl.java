package com.bridgelabz.bookstorebackend.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.bookstorebackend.data.CustomerData;
import com.bridgelabz.bookstorebackend.dto.LoginDTO;
import com.bridgelabz.bookstorebackend.dto.SignUpDTO;
import com.bridgelabz.bookstorebackend.repository.CustomerRepository;
import com.bridgelabz.bookstorebackend.service.CustomerServiceIF;

public class CustomerServiceImpl implements CustomerServiceIF {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public CustomerData signUpCustomer(SignUpDTO signUpDTO) {
		CustomerData customerData = new CustomerData(signUpDTO);
		return customerRepository.save(customerData);
	}

	@Override
	public CustomerData loginCustomer(LoginDTO loginDTO) {
		return customerRepository.loginCustomer(loginDTO.getEmail(), loginDTO.getPassword());
	}

}
