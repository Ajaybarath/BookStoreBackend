package com.bridgelabz.bookstorebackend.repository;

import com.bridgelabz.bookstorebackend.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<ApplicationUser, Integer>{
	@Query(value = "SELECT * FROM user WHERE email = :email AND password = :password", nativeQuery = true)
    ApplicationUser loginCustomer(String email, String password);

	@Query(value = "SELECT * FROM user WHERE email = :email", nativeQuery = true)
    ApplicationUser getPassword(String email);

	ApplicationUser findUserByEmail(String email);

	ApplicationUser findByResetPasswordToken(String token);
}
