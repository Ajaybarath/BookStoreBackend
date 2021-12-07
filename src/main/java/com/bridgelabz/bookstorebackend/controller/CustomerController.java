package com.bridgelabz.bookstorebackend.controller;

import com.bridgelabz.bookstorebackend.implementation.UserDetailServiceImpl;
import com.bridgelabz.bookstorebackend.model.ApplicationUser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bridgelabz.bookstorebackend.model.Address;
import com.bridgelabz.bookstorebackend.dto.SignUpDTO;
import com.bridgelabz.bookstorebackend.dto.AddressDTO;
import com.bridgelabz.bookstorebackend.dto.ResponseDTO;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("bookstore/user")
public class CustomerController {

	@Autowired
	UserDetailServiceImpl customerService;

	@PostMapping("/signup")
	public ResponseEntity<ResponseDTO> signUpCustomer(@RequestBody SignUpDTO signUpDTO) {
		ApplicationUser applicationUserData = null;
		applicationUserData = customerService.signUpCustomer(signUpDTO);
		ResponseDTO responseDTO = new ResponseDTO("Signed Up", applicationUserData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	@PutMapping("/editDetails")
	public ResponseEntity<ResponseDTO> editPersonalDetails(@RequestBody SignUpDTO signUpDTO, @RequestHeader("userId") int userId) {
		ApplicationUser applicationUserData = null;
		applicationUserData = customerService.editPersonalDetails(signUpDTO, userId);
		ResponseDTO responseDTO = new ResponseDTO("User Details Updated", applicationUserData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/getByEmail")
	public ResponseEntity<ResponseDTO> getUserDataByEmail(@RequestHeader("email") String email) {
		ApplicationUser userData = null;
		userData = customerService.getUserDataByEmail(email);
		ResponseDTO responseDTO = new ResponseDTO("Logged In", userData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/get")
	public ResponseEntity<ResponseDTO> getCustomerById(@RequestHeader("userId") int userId) {
		ApplicationUser applicationUserData = null;
		applicationUserData = customerService.getCustomerById(userId);
		ResponseDTO responseDTO = new ResponseDTO("User Found", applicationUserData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/forgotPassword")
	public ResponseEntity<ResponseDTO> getPassword(@RequestBody String email) {
		ApplicationUser applicationUserData = null;
		applicationUserData = customerService.getPassword(email);
		ResponseDTO responseDTO = new ResponseDTO("User Details", applicationUserData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/createAddress")
	public ResponseEntity<ResponseDTO> addAddress(@RequestBody AddressDTO addressDTO,
			@RequestHeader("userId") int userId) {
		Address addressData = null;
		addressData = customerService.addAddress(userId, addressDTO);
		ResponseDTO responseDTO = new ResponseDTO("Address Added", addressData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PutMapping("/updateAddress")
	public ResponseEntity<ResponseDTO> updateAddress(@RequestBody AddressDTO addressDTO,
			@RequestHeader("userId") int userId) {
		Address addressData = null;
		addressData = customerService.updateAddress(userId, addressDTO);
		ResponseDTO responseDTO = new ResponseDTO("Address Updated", addressData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	@GetMapping("/getAddress")
	public ResponseEntity<ResponseDTO> getAddress(@RequestHeader("userId") int userId) {
		List<Address> addressData = null;
		addressData = customerService.getAddress(userId);
		ResponseDTO responseDTO = new ResponseDTO("Address Found", addressData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}
