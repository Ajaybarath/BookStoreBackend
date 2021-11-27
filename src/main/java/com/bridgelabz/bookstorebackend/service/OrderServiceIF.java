package com.bridgelabz.bookstorebackend.service;

import java.util.List;
import java.util.UUID;

import com.bridgelabz.bookstorebackend.model.MyOrder;
import com.bridgelabz.bookstorebackend.dto.MyOrderDTO;

public interface OrderServiceIF {

	List<MyOrder> getOrders(UUID customerId);

	MyOrder createOrders(UUID customerId, MyOrderDTO myOrderDTO);

	Object getBookWithOrders(UUID customerId);

}
