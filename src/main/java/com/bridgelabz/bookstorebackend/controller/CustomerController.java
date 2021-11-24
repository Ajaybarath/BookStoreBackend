package com.bridgelabz.bookstorebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.bookstorebackend.data.CustomerData;
import com.bridgelabz.bookstorebackend.dto.SignUpDTO;
import com.bridgelabz.bookstorebackend.service.CustomerServiceIF;
import com.bridgelabz.bookstorebackend.dto.LoginDTO;
import com.bridgelabz.bookstorebackend.dto.ResponseDTO;

@RestController
@RequestMapping("/customer/")
public class CustomerController {

	@Autowired
	CustomerServiceIF customerService;
	
	@PostMapping("/signup")
    public ResponseEntity<ResponseDTO> signUpCustomer(@RequestBody SignUpDTO signUpDTO) {
        CustomerData customerData = null;
        customerData = customerService.signUpCustomer(signUpDTO);
        ResponseDTO responseDTO = new ResponseDTO("Signed Up", customerData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
	
	@PostMapping("/login")
    public ResponseEntity<ResponseDTO> loginCustomer(@RequestBody LoginDTO loginDTO) {
        CustomerData customerData = null;
        customerData = customerService.loginCustomer(loginDTO);
        ResponseDTO responseDTO = new ResponseDTO("Logged In", customerData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}