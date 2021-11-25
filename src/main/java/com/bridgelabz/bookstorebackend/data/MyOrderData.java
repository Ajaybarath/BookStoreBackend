package com.bridgelabz.bookstorebackend.data;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "my_order")
public class MyOrderData {

	@Id
	int orderId;

	@JoinColumn(name = "customer.customer_id")
	int customerId;

	@JoinColumn(name = "books.book_id")
	int bookId;
	
	int quantity;

	LocalDate orderDate;
}
