package com.bridgelabz.bookstorebackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.bridgelabz.bookstorebackend.dto.AddressDTO;

import lombok.Data;

@Entity
@Table(name = "address")
public @Data class Address {

	@Id
	@JoinColumn(name = "customer.customer_id")
	int customerId;
	String address;
	String city;
	String state;
	String addressType;

	public Address() {

	}

	public Address(int customerId, AddressDTO addressDTO) {
		this.customerId = customerId;
		this.address = addressDTO.getAddress();
		this.city = addressDTO.getCity();
		this.state = addressDTO.getState();
		this.addressType = addressDTO.getAddressType();
	}
	
	public void updateAddress(int customerId, AddressDTO addressDTO) {
		this.customerId = customerId;
		this.address = addressDTO.getAddress();
		this.city = addressDTO.getCity();
		this.state = addressDTO.getState();
		this.addressType = addressDTO.getAddressType();
	}
}
