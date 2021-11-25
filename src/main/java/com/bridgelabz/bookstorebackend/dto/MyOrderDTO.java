package com.bridgelabz.bookstorebackend.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

public @Data class MyOrderDTO {
	
	int bookId;
	int totalCost;
	int quantity;
	
	@JsonFormat(pattern="dd MMM yyyy")
	LocalDate orderDate;
}
