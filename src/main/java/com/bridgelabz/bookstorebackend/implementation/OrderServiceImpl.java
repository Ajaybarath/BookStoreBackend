package com.bridgelabz.bookstorebackend.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.bookstorebackend.data.MyOrderData;
import com.bridgelabz.bookstorebackend.dto.MyOrderDTO;
import com.bridgelabz.bookstorebackend.repository.OrderRepository;
import com.bridgelabz.bookstorebackend.service.OrderServiceIF;

@Service
public class OrderServiceImpl implements OrderServiceIF {

	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public List<MyOrderData> getOrders(int customerId) {
		return orderRepository.getOrderByCustomerId(customerId);
	}

	@Override
	public MyOrderData createOrders(int customerId, MyOrderDTO myOrderDTO) {
		MyOrderData myOrderData = new MyOrderData(customerId, myOrderDTO);
		return orderRepository.save(myOrderData);
		
	}
}
