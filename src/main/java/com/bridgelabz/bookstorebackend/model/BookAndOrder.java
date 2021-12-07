package com.bridgelabz.bookstorebackend.model;

import java.time.LocalDate;

import lombok.Data;

public @Data class BookAndOrder {

	private int bookId;
	private String name;
	private int price;
	private int mrp;
	private String details;
	private String author;
	private double rating;
	private int noOfRating;
	private String imageUrl;
	private int orderId;
	private int userId;
	private int totalCost;
	private int quantity;
	private LocalDate orderDate;

	public BookAndOrder(Books books, MyOrder myOrder) {
		this.bookId = books.getId();
		this.name = books.getName();
		this.price = books.getPrice();
		this.mrp = books.getMrp();
		this.details = books.getDetails();
		this.author = books.getAuthor();
		this.rating = books.getRating();
		this.noOfRating = books.getNoOfRating();
		this.imageUrl = books.getImageUrl();
		this.orderId = myOrder.getOrderId();
		this.userId = myOrder.getUserId();
		this.totalCost = myOrder.getTotalCost();
		this.quantity = myOrder.getQuantity();
		this.orderDate = myOrder.getOrderDate();
	}

}
