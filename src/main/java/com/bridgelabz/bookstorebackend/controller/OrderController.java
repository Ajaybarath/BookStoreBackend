package com.bridgelabz.bookstorebackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.bookstorebackend.data.MyOrder;
import com.bridgelabz.bookstorebackend.dto.MyOrderDTO;
import com.bridgelabz.bookstorebackend.dto.ResponseDTO;
import com.bridgelabz.bookstorebackend.service.OrderServiceIF;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderServiceIF orderService;
	
	@PostMapping("/createOrders")
	public ResponseEntity<ResponseDTO> createlOrders(@RequestBody MyOrderDTO myOrderDTO,
			@RequestHeader("customerId") int customerId) {
		MyOrder myOrderData = orderService.createOrders(customerId, myOrderDTO);
		ResponseDTO responseDTO = new ResponseDTO("Order Created", myOrderData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/getOrders")
	public ResponseEntity<ResponseDTO> getAllOrders(@RequestHeader("customerId") int customerId) {
		List<MyOrder> myOrderData = orderService.getOrders(customerId);
		ResponseDTO responseDTO = new ResponseDTO("My Orders", myOrderData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}
