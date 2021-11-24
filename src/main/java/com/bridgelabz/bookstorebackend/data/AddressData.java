package com.bridgelabz.bookstorebackend.data;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "address")
public @Data class AddressData {
	
	int customerId;
	String address;
	String city;
	String state;
	String addressType;
}
