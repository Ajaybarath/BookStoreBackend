package com.bridgelabz.bookstorebackend.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

public @Data
@AllArgsConstructor class MyOrderDTO {

	@NotNull(message = "BookId Should Not be Empty")
	public int bookId;

	@NotNull(message = "Cost Should Not be Empty")
	public int totalCost;

	@NotNull(message = "Quantity Should Not be Empty")
	public int quantity;

	@JsonFormat(pattern = "dd MMM yyyy")
	@NotNull(message = "Date Should Not be Empty")
	@PastOrPresent(message = "Date should be past or todays date")
	public LocalDate orderDate;

}
