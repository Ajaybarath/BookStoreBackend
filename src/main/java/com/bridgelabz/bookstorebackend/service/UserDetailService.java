package com.bridgelabz.bookstorebackend.service;

import com.bridgelabz.bookstorebackend.model.Address;
import com.bridgelabz.bookstorebackend.model.ApplicationUser;
import com.bridgelabz.bookstorebackend.dto.AddressDTO;
import com.bridgelabz.bookstorebackend.dto.LoginDTO;
import com.bridgelabz.bookstorebackend.dto.SignUpDTO;

public interface UserDetailService {

	ApplicationUser signUpCustomer(SignUpDTO signUpDTO);

	ApplicationUser loginCustomer(LoginDTO loginDTO);

	ApplicationUser getCustomerById(int userId);

	Address addAddress(int userId, AddressDTO addressDTO);

	Address updateAddress(int userId, AddressDTO addressDTO);

	ApplicationUser getPassword(String email);

	ApplicationUser editPersonalDetails(SignUpDTO signUpDTO, int userId);

	ApplicationUser loadUserByUsername(String email);

}
