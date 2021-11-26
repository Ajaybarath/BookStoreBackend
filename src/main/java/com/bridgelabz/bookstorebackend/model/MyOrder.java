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
	int orderId;

	@JoinColumn(name = "customer.customer_id")
	int customerId;

	@JoinColumn(name = "books.book_id")
	int bookId;

	int totalCost;

	int quantity;

	LocalDate orderDate;

	public MyOrder() {

	}

	public MyOrder(int customerId, MyOrderDTO myOrderDTO) {
		this.customerId = customerId;
		this.bookId = myOrderDTO.getBookId();
		this.totalCost = myOrderDTO.getTotalCost();
		this.quantity = myOrderDTO.getQuantity();
		this.orderDate = myOrderDTO.getOrderDate();
	}
}
