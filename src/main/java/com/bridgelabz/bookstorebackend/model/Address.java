package com.bridgelabz.bookstorebackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.bridgelabz.bookstorebackend.dto.AddressDTO;

import lombok.Data;

@Entity
@Table(name = "address")
public @Data class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private int addressId;
	
	@JoinColumn(name = "user.user_id")
	private int userId;
	private String address;
	private String city;
	private String state;
	private String addressType;

	public Address() {

	}

	public Address(int userId, AddressDTO addressDTO) {
		this.userId = userId;
		this.address = addressDTO.getAddress();
		this.city = addressDTO.getCity();
		this.state = addressDTO.getState();
		this.addressType = addressDTO.getAddressType();
	}

	public void updateAddress(int userId, AddressDTO addressDTO) {
		this.userId = userId;
		this.address = addressDTO.getAddress();
		this.city = addressDTO.getCity();
		this.state = addressDTO.getState();
		this.addressType = addressDTO.getAddressType();
	}
}
