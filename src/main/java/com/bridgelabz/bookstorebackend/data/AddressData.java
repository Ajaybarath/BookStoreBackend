package com.bridgelabz.bookstorebackend.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.bookstorebackend.dto.AddressDTO;

import lombok.Data;

@Entity
@Table(name = "address")
public @Data class AddressData {

	@Id
	int customerId;
	String address;
	String city;
	String state;
	String addressType;

	public AddressData() {

	}

	public AddressData(int customerId, AddressDTO addressDTO) {
		this.customerId = customerId;
		this.address = addressDTO.getAddress();
		this.city = addressDTO.getCity();
		this.state = addressDTO.getState();
		this.addressType = addressDTO.getAddressType();
	}
}
