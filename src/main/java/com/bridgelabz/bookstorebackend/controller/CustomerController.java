package com.bridgelabz.bookstorebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bridgelabz.bookstorebackend.model.Address;
import com.bridgelabz.bookstorebackend.model.User;
import com.bridgelabz.bookstorebackend.dto.SignUpDTO;
import com.bridgelabz.bookstorebackend.service.CustomerServiceIF;
import com.bridgelabz.bookstorebackend.dto.AddressDTO;
import com.bridgelabz.bookstorebackend.dto.LoginDTO;
import com.bridgelabz.bookstorebackend.dto.ResponseDTO;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/bookstore/customer")
public class CustomerController {

	@Autowired
	CustomerServiceIF customerService;

	@PostMapping("/signup")
	public ResponseEntity<ResponseDTO> signUpCustomer(@RequestBody SignUpDTO signUpDTO) {
		User userData = null;
		userData = customerService.signUpCustomer(signUpDTO);
		ResponseDTO responseDTO = new ResponseDTO("Signed Up", userData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<ResponseDTO> loginCustomer(@RequestBody LoginDTO loginDTO) {
		User userData = null;
		userData = customerService.loginCustomer(loginDTO);
		ResponseDTO responseDTO = new ResponseDTO("Logged In", userData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/get")
	public ResponseEntity<ResponseDTO> getCustomerById(@RequestHeader("customerId") int customerId) {
		User userData = null;
		userData = customerService.getCustomerById(customerId);
		ResponseDTO responseDTO = new ResponseDTO("Customer Found", userData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/forgotPassword")
	public ResponseEntity<ResponseDTO> getPassword(@RequestBody String email) {
		User userData = null;
		userData = customerService.getPassword(email);
		ResponseDTO responseDTO = new ResponseDTO("Customer Details", userData);
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
