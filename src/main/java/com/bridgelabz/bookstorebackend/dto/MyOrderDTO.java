package com.bridgelabz.bookstorebackend.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

public @Data class MyOrderDTO {
	
	@NotNull(message= "BookId Should Not be Empty")
	int bookId;
	
	@NotNull(message= "Cost Should Not be Empty")
	int totalCost;
	
	@NotNull(message= "Quantity Should Not be Empty")
	int quantity;
	
	@JsonFormat(pattern="dd MMM yyyy")
	@NotNull(message="Start date should not be empty")
	@PastOrPresent(message = "Start date should be past or todays date")
	LocalDate orderDate;
}
