package com.bridgelabz.bookstorebackend.implementation;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.bookstorebackend.model.MyOrder;
import com.bridgelabz.bookstorebackend.dto.MyOrderDTO;
import com.bridgelabz.bookstorebackend.repository.OrderRepository;
import com.bridgelabz.bookstorebackend.service.OrderServiceIF;

@Service
public class OrderServiceImpl implements OrderServiceIF {

	@Autowired
	OrderRepository orderRepository;

	@Override
	public List<MyOrder> getOrders(UUID customerId) {
		return orderRepository.getOrderByCustomerId(customerId);
	}

	@Override
	public MyOrder createOrders(UUID customerId, MyOrderDTO myOrderDTO) {
		MyOrder myOrderData = new MyOrder(customerId, myOrderDTO);
		return orderRepository.save(myOrderData);

	}

	@Override
	public Object getBookWithOrders(UUID customerId) {
		return orderRepository.getBookWithOrder(customerId);
	}
}
