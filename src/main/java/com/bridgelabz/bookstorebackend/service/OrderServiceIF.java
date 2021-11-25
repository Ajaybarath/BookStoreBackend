package com.bridgelabz.bookstorebackend.service;

import java.util.List;

import com.bridgelabz.bookstorebackend.data.MyOrderData;
import com.bridgelabz.bookstorebackend.dto.MyOrderDTO;

public interface OrderServiceIF {

	List<MyOrderData> getOrders(int customerId);

	MyOrderData createOrders(int customerId, MyOrderDTO myOrderDTO);

}
