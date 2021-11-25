package com.bridgelabz.bookstorebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.bookstorebackend.data.AddressData;

public interface AddressRepository extends JpaRepository<AddressData, Integer>{

	@Query(value = "SELECT * FROM address WHERE customer_id = :customerId AND address_type = :addressType", nativeQuery = true)
	AddressData getAddress(int customerId, String addressType);
}
