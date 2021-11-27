package com.bridgelabz.bookstorebackend.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.bookstorebackend.dto.LoginDTO;
import com.bridgelabz.bookstorebackend.dto.SignUpDTO;

import lombok.Data;

@Entity
@Table(name = "customer")
public @Data class Customer {

	@Id
	@Column(name = "customer_id", columnDefinition = "BINARY(16)")
	@GeneratedValue
	private UUID customerId;

	private String fullName;

	@Column(unique = true)
	private String phoneNumber;

	@Column(unique = true)
	private String email;
	private String password;

	public Customer() {

	}

	public Customer(SignUpDTO signUpDTO) {
		this.fullName = signUpDTO.getFullName();
		this.phoneNumber = signUpDTO.getPhoneNumber();
		this.email = signUpDTO.getEmail();
		this.password = signUpDTO.getPassword();
	}

	public Customer(LoginDTO loginDTO) {
		this.email = loginDTO.getEmail();
		this.password = loginDTO.getPassword();
	}
}
