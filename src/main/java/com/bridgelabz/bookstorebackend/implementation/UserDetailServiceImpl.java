package com.bridgelabz.bookstorebackend.implementation;

import com.bridgelabz.bookstorebackend.model.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bridgelabz.bookstorebackend.model.Address;
import com.bridgelabz.bookstorebackend.dto.AddressDTO;
import com.bridgelabz.bookstorebackend.dto.SignUpDTO;
import com.bridgelabz.bookstorebackend.exception.BooksException;
import com.bridgelabz.bookstorebackend.repository.AddressRepository;
import com.bridgelabz.bookstorebackend.repository.CustomerRepository;

import static java.util.Collections.emptyList;
//import com.bridgelabz.bookstorebackend.service.UserDetailService;

import java.util.List;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ApplicationUser signUpCustomer(SignUpDTO signUpDTO) {
        ApplicationUser applicationUserData = new ApplicationUser(signUpDTO);
        applicationUserData.setPassword(bCryptPasswordEncoder.encode(signUpDTO.getPassword()));
        return customerRepository.save(applicationUserData);
    }

    public ApplicationUser getPassword(String email) {
        return customerRepository.getPassword(email);
    }

    public ApplicationUser getCustomerById(int userId) {
        return customerRepository.findById(userId).orElseThrow(() -> new BooksException("User Not Found"));
    }

    public Address getAddressById(int userId, String addressType) {
        return addressRepository.getAddress(userId, addressType);
    }

    public Address addAddress(int userId, AddressDTO addressDTO) {
        Address addressData = new Address(userId, addressDTO);
        return addressRepository.save(addressData);
    }

    public Address updateAddress(int userId, AddressDTO addressDTO) {
        Address addressData = this.getAddressById(userId, addressDTO.getAddressType());
        addressData.updateAddress(userId, addressDTO);
        return addressRepository.save(addressData);
    }


    public ApplicationUser editPersonalDetails(SignUpDTO signUpDTO, int userId) {
        ApplicationUser applicationUser = this.getCustomerById(userId);
        applicationUser.updateDetails(signUpDTO, userId);
        applicationUser.setPassword(bCryptPasswordEncoder.encode(signUpDTO.getPassword()));
        return customerRepository.save(applicationUser);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ApplicationUser applicationUser = customerRepository.findUserByEmail(email);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(email);
        }
        return new User(applicationUser.getEmail(), applicationUser.getPassword(), emptyList());
    }


    public ApplicationUser getUserDataByEmail(String email) {
        return customerRepository.findUserByEmail(email);
    }

	public List<Address> getAddress(int userId) {
		List<Address> address= addressRepository.findAddressByUserId(userId);
		return address;
	}
}
