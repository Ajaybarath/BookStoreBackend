package com.bridgelabz.bookstorebackend.dto;

import lombok.Data;

public @Data class SignUpDTO {

	String FullName;
	String phoneNumber;
	String email;
	String password;
}
