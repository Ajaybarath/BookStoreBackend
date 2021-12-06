package com.bridgelabz.bookstorebackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bridgelabz.bookstorebackend.model.BookAndOrder;
import com.bridgelabz.bookstorebackend.model.MyOrder;
import com.bridgelabz.bookstorebackend.dto.MyOrderDTO;
import com.bridgelabz.bookstorebackend.dto.ResponseDTO;
import com.bridgelabz.bookstorebackend.service.OrderServiceIF;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("bookstore/order")
public class OrderController {

    @Autowired
    OrderServiceIF orderService;

    @PostMapping("/createOrders/{userId}")
    public ResponseEntity<ResponseDTO> createlOrders(@PathVariable("userId") int userId) {
        String myOrderData = orderService.createOrders(userId);
        ResponseDTO responseDTO = new ResponseDTO("Order Created", myOrderData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getOrders")
    public ResponseEntity<ResponseDTO> getAllOrders(@RequestHeader("userId") int userId) {
        List<MyOrder> myOrderData = orderService.getOrders(userId);
        ResponseDTO responseDTO = new ResponseDTO("My Orders", myOrderData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getBookWithOrder")
    public ResponseEntity<ResponseDTO> getBookWithOrders(@RequestHeader("userId") int userId) {
        List<BookAndOrder> myOrderData = orderService.getBookWithOrders(userId);
        ResponseDTO responseDTO = new ResponseDTO("Order Along with Book", myOrderData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
