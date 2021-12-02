package com.bridgelabz.bookstorebackend.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.bookstorebackend.dto.CartDTO;
import com.bridgelabz.bookstorebackend.dto.CartItemDTO;
import com.bridgelabz.bookstorebackend.model.Cart;
import com.bridgelabz.bookstorebackend.repository.CartRepository;
import com.bridgelabz.bookstorebackend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.bookstorebackend.model.BookAndOrder;
import com.bridgelabz.bookstorebackend.model.Books;
import com.bridgelabz.bookstorebackend.model.MyOrder;
import com.bridgelabz.bookstorebackend.dto.MyOrderDTO;
import com.bridgelabz.bookstorebackend.exception.BooksException;
import com.bridgelabz.bookstorebackend.repository.BooksRepository;
import com.bridgelabz.bookstorebackend.repository.OrderRepository;
import com.bridgelabz.bookstorebackend.service.BooksService;
import com.bridgelabz.bookstorebackend.service.OrderServiceIF;

@Service
public class OrderServiceImpl implements OrderServiceIF {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	BooksRepository booksRepository;

	@Autowired
	CartService cartService;
	
	@Autowired
	BooksService booksService;

	@Override
	public List<MyOrder> getOrders(int userId) {
		return orderRepository.getOrderByCustomerId(userId);
	}

	@Override
	public String createOrders(int userId) {
		List<CartDTO> cartList = cartService.getCartItemList(userId);
		cartList.forEach((cartItem) -> {
			orderRepository.save(new MyOrder(userId, new MyOrderDTO(cartItem.getBooks().getId(), cartItem.getTotal(), cartItem.getQuantity(), LocalDate.now())));
			cartService.removeItemFromCart(userId, new CartItemDTO(userId, cartItem.getBooks().getId(), cartItem.getQuantity()));
		});
		return "Order place successfully";

	}

	@Override
	public List<BookAndOrder> getBookWithOrders(int userId) {
		List<BookAndOrder> bookAndOrder = new ArrayList<>();
		List<MyOrder> myOrders = orderRepository.getOrderByCustomerId(userId);
		myOrders.forEach(order -> {
			Books books = booksRepository.findById(order.getBookId()).orElseThrow(() -> new BooksException("Books not found"));
			bookAndOrder.add(new BookAndOrder(books, order));	
		});
		return bookAndOrder;
	}
}
