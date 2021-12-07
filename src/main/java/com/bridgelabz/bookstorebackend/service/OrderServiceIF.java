package com.bridgelabz.bookstorebackend.service;

import java.util.List;

import com.bridgelabz.bookstorebackend.model.BookAndOrder;
import com.bridgelabz.bookstorebackend.model.MyOrder;
import com.bridgelabz.bookstorebackend.dto.MyOrderDTO;

public interface OrderServiceIF {

	List<MyOrder> getOrders(int userId);

	String createOrders(int userId);

	List<BookAndOrder> getBookWithOrders(int userId);

}
