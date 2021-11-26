package com.bridgelabz.bookstorebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.bookstorebackend.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query(value = "SELECT * FROM customer WHERE email = :email AND password = :password", nativeQuery = true)
	Customer loginCustomer(String email, String password);
}
