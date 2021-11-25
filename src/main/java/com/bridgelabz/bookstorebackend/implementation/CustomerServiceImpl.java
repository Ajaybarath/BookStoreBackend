package com.bridgelabz.bookstorebackend.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.bookstorebackend.data.AddressData;
import com.bridgelabz.bookstorebackend.data.CustomerData;
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
	public CustomerData signUpCustomer(SignUpDTO signUpDTO) {
		CustomerData customerData = new CustomerData(signUpDTO);
		return customerRepository.save(customerData);
	}

	@Override
	public CustomerData loginCustomer(LoginDTO loginDTO) {
		return customerRepository.loginCustomer(loginDTO.getEmail(), loginDTO.getPassword());
	}
	
	@Override
	public CustomerData getCustomerById(int customerId) {
		return customerRepository.findById(customerId).orElseThrow(() -> new BooksException("Customer Not Found"));
	}

	public AddressData getAddressById(int customerId, String addressType) {
		return addressRepository.getAddress(customerId, addressType);
	}

	@Override
	public AddressData addAddress(int customerId, AddressDTO addressDTO) {
		AddressData addressData = new AddressData(customerId, addressDTO);
		return addressRepository.save(addressData);
	}

	@Override
	public AddressData updateAddress(int customerId, AddressDTO addressDTO) {
		AddressData addressData = this.getAddressById(customerId, addressDTO.getAddressType());
		addressData.updateAddress(customerId, addressDTO);
		return addressRepository.save(addressData);
	}


}
