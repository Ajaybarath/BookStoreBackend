package com.bridgelabz.bookstorebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.bookstorebackend.data.CustomerData;

public interface CustomerRepository extends JpaRepository<CustomerData, Integer>{

	@Query(value = "SELECT * FROM customer WHERE email = :email AND password = :password", nativeQuery = true)
	CustomerData loginCustomer(String email, String password);
}
