package com.bridgelabz.bookstorebackend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.bookstorebackend.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, UUID>{

	@Query(value = "SELECT * FROM customer WHERE email = :email AND password = :password", nativeQuery = true)
	Customer loginCustomer(String email, String password);

	@Query(value = "SELECT * FROM customer WHERE email = :email", nativeQuery = true)
	Customer getPassword(String email);
}
