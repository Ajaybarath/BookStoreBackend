package com.bridgelabz.bookstorebackend.model;

import java.util.UUID;

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
	private UUID customerId;
	private String address;
	private String city;
	private String state;
	private String addressType;

	public Address() {

	}

	public Address(UUID customerId, AddressDTO addressDTO) {
		this.customerId = customerId;
		this.address = addressDTO.getAddress();
		this.city = addressDTO.getCity();
		this.state = addressDTO.getState();
		this.addressType = addressDTO.getAddressType();
	}

	public void updateAddress(UUID customerId, AddressDTO addressDTO) {
		this.customerId = customerId;
		this.address = addressDTO.getAddress();
		this.city = addressDTO.getCity();
		this.state = addressDTO.getState();
		this.addressType = addressDTO.getAddressType();
	}
}
