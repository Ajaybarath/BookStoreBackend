package com.bridgelabz.bookstorebackend.implementation;

import java.util.List;

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
	public List<MyOrder> getOrders(int userId) {
		return orderRepository.getOrderByCustomerId(userId);
	}

	@Override
	public MyOrder createOrders(int userId, MyOrderDTO myOrderDTO) {
		MyOrder myOrderData = new MyOrder(userId, myOrderDTO);
		return orderRepository.save(myOrderData);

	}

	@Override
	public Object getBookWithOrders(int userId) {
		return orderRepository.getBookWithOrder(userId);
	}
}
