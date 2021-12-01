package com.bridgelabz.bookstorebackend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.bookstorebackend.model.Address;

public interface AddressRepository extends JpaRepository<Address, UUID>{

	@Query(value = "SELECT * FROM address WHERE user_id = :userId AND address_type = :addressType", nativeQuery = true)
	Address getAddress(int userId, String addressType);
}
