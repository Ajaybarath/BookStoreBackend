package com.bridgelabz.bookstorebackend.service;

import java.util.List;

import com.bridgelabz.bookstorebackend.model.MyOrder;
import com.bridgelabz.bookstorebackend.dto.MyOrderDTO;

public interface OrderServiceIF {

	List<MyOrder> getOrders(int userId);

	MyOrder createOrders(int userId, MyOrderDTO myOrderDTO);

	List<Object> getBookWithOrders(int userId);
}
