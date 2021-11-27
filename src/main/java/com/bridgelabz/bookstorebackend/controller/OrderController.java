package com.bridgelabz.bookstorebackend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.bookstorebackend.model.MyOrder;
import com.bridgelabz.bookstorebackend.dto.MyOrderDTO;
import com.bridgelabz.bookstorebackend.dto.ResponseDTO;
import com.bridgelabz.bookstorebackend.service.OrderServiceIF;

@RestController
@RequestMapping("/bookstore/order")
public class OrderController {

	@Autowired
	OrderServiceIF orderService;

	@PostMapping("/createOrders")
	public ResponseEntity<ResponseDTO> createlOrders(@RequestBody MyOrderDTO myOrderDTO,
			@RequestHeader("customerId") UUID customerId) {
		MyOrder myOrderData = orderService.createOrders(customerId, myOrderDTO);
		ResponseDTO responseDTO = new ResponseDTO("Order Created", myOrderData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/getOrders")
	public ResponseEntity<ResponseDTO> getAllOrders(@RequestHeader("customerId") UUID customerId) {
		List<MyOrder> myOrderData = orderService.getOrders(customerId);
		ResponseDTO responseDTO = new ResponseDTO("My Orders", myOrderData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/getBookWithOrder")
	public ResponseEntity<ResponseDTO> getBookWithOrders(@RequestHeader("customerId") UUID customerId) {
		Object myOrderData = orderService.getBookWithOrders(customerId);
		ResponseDTO responseDTO = new ResponseDTO("Order Along with Book", myOrderData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}
