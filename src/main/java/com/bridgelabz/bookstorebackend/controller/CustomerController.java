package com.bridgelabz.bookstorebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.bookstorebackend.model.Address;
import com.bridgelabz.bookstorebackend.model.Customer;
import com.bridgelabz.bookstorebackend.dto.SignUpDTO;
import com.bridgelabz.bookstorebackend.service.CustomerServiceIF;
import com.bridgelabz.bookstorebackend.dto.AddressDTO;
import com.bridgelabz.bookstorebackend.dto.LoginDTO;
import com.bridgelabz.bookstorebackend.dto.ResponseDTO;

@RestController
@RequestMapping("/bookstore/customer")
public class CustomerController {

	@Autowired
	CustomerServiceIF customerService;

	@PostMapping("/signup")
	public ResponseEntity<ResponseDTO> signUpCustomer(@RequestBody SignUpDTO signUpDTO) {
		Customer customerData = null;
		customerData = customerService.signUpCustomer(signUpDTO);
		ResponseDTO responseDTO = new ResponseDTO("Signed Up", customerData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<ResponseDTO> loginCustomer(@RequestBody LoginDTO loginDTO) {
		Customer customerData = null;
		customerData = customerService.loginCustomer(loginDTO);
		ResponseDTO responseDTO = new ResponseDTO("Logged In", customerData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/get")
	public ResponseEntity<ResponseDTO> getCustomerById(@RequestHeader("customerId") int customerId) {
		Customer customerData = null;
		customerData = customerService.getCustomerById(customerId);
		ResponseDTO responseDTO = new ResponseDTO("Customer Found", customerData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/forgotPassword")
	public ResponseEntity<ResponseDTO> getPassword(@RequestBody String email) {
		Customer customerData = null;
		customerData = customerService.getPassword(email);
		ResponseDTO responseDTO = new ResponseDTO("Customer Details", customerData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/createAddress")
	public ResponseEntity<ResponseDTO> addAddress(@RequestBody AddressDTO addressDTO,
			@RequestHeader("customerId") int customerId) {
		Address addressData = null;
		addressData = customerService.addAddress(customerId, addressDTO);
		ResponseDTO responseDTO = new ResponseDTO("Address Added", addressData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PutMapping("/updateAddress")
	public ResponseEntity<ResponseDTO> updateAddress(@RequestBody AddressDTO addressDTO,
			@RequestHeader("customerId") int customerId) {
		Address addressData = null;
		addressData = customerService.updateAddress(customerId, addressDTO);
		ResponseDTO responseDTO = new ResponseDTO("Address Updated", addressData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}
