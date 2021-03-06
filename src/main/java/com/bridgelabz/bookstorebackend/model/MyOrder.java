package com.bridgelabz.bookstorebackend.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.bridgelabz.bookstorebackend.dto.MyOrderDTO;

import lombok.Data;

@Entity
@Table(name = "my_order")
public @Data class MyOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private int orderId;

	@JoinColumn(name = "user.user_id")
	private int userId;

	@JoinColumn(name = "books.book_id")
	private int bookId;

	private int totalCost;

	private int quantity;

	private LocalDate orderDate;

	public MyOrder() {

	}

	public MyOrder(int userId, MyOrderDTO myOrderDTO) {
		this.userId = userId;
		this.bookId = myOrderDTO.getBookId();
		this.totalCost = myOrderDTO.getTotalCost();
		this.quantity = myOrderDTO.getQuantity();
		this.orderDate = myOrderDTO.getOrderDate();
	}
}
