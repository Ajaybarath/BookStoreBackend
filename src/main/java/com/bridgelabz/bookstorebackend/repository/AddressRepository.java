package com.bridgelabz.bookstorebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.bookstorebackend.data.AddressData;

public interface AddressRepository extends JpaRepository<AddressData, Integer>{

}
