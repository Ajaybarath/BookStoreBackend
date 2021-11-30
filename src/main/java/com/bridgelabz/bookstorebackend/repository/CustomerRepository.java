package com.bridgelabz.bookstorebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.bookstorebackend.model.User;

public interface CustomerRepository extends JpaRepository<User, Integer>{
	@Query(value = "SELECT * FROM user WHERE email = :email AND password = :password", nativeQuery = true)
    User loginCustomer(String email, String password);

	@Query(value = "SELECT * FROM user WHERE email = :email", nativeQuery = true)
    User getPassword(String email);
}
