package com.bridgelabz.bookstorebackend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.bookstorebackend.model.User;

<<<<<<< HEAD
public interface CustomerRepository extends JpaRepository<User, Integer>{
=======
public interface CustomerRepository extends JpaRepository<Customer, UUID>{
>>>>>>> localbranch

	@Query(value = "SELECT * FROM user WHERE email = :email AND password = :password", nativeQuery = true)
    User loginCustomer(String email, String password);

	@Query(value = "SELECT * FROM user WHERE email = :email", nativeQuery = true)
    User getPassword(String email);
}
