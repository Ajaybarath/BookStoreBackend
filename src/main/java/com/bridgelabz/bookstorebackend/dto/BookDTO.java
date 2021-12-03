package com.bridgelabz.bookstorebackend.dto;

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

}
