package com.bridgelabz.bookstorebackend.implementation;

import java.util.List;

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
	public User getCustomerById(int userId) {
		return customerRepository.findById(userId).orElseThrow(() -> new BooksException("User Not Found"));
	}

	public Address getAddressById(int userId, String addressType) {
		return addressRepository.getAddress(userId, addressType);
	}

	@Override
	public Address addAddress(int userId, AddressDTO addressDTO) {
		Address addressData = new Address(userId, addressDTO);
		return addressRepository.save(addressData);
	}

	@Override
	public Address updateAddress(int userId, AddressDTO addressDTO) {
		Address addressData = this.getAddressById(userId, addressDTO.getAddressType());
		addressData.updateAddress(userId, addressDTO);
		return addressRepository.save(addressData);
	}

	@Override
	public User editPersonalDetails(SignUpDTO signUpDTO, int userId) {
		User user = this.getCustomerById(userId);
		user.updateDetails(signUpDTO, userId);
		return customerRepository.save(user);
	}

	@Override
	public List<Address> getAddress(int userId) {
		List<Address> address= addressRepository.findAddressByUserId(userId);
		return address;
	}

}
