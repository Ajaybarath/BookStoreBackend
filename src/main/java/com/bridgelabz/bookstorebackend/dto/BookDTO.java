package com.bridgelabz.bookstorebackend.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.ToString;

public @Data @ToString class BookDTO {

	String name;
	int price;
	int mrp;
	String details;
	String author;
	int quantity;
	String imageUrl;
	
	@JsonFormat(pattern = "dd MMM yyyy")
	@NotNull(message = "Date Should Not be Empty")
	@PastOrPresent(message = "Date should be past or todays date")
	public LocalDate createDate;

}
