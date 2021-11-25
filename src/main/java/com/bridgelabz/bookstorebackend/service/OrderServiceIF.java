package com.bridgelabz.bookstorebackend.service;

import java.util.List;

import com.bridgelabz.bookstorebackend.data.MyOrder;
import com.bridgelabz.bookstorebackend.dto.MyOrderDTO;

public interface OrderServiceIF {

	List<MyOrder> getOrders(int customerId);

	MyOrder createOrders(int customerId, MyOrderDTO myOrderDTO);

}
