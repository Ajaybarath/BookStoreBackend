package com.bridgelabz.bookstorebackend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.bookstorebackend.model.Address;

public interface AddressRepository extends JpaRepository<Address, UUID>{

	@Query(value = "SELECT * FROM address WHERE customer_id = :customerId AND address_type = :addressType", nativeQuery = true)
	Address getAddress(UUID customerId, String addressType);
}
