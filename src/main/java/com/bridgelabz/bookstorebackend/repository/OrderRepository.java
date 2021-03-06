package com.bridgelabz.bookstorebackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.bookstorebackend.model.BookAndOrder;
import com.bridgelabz.bookstorebackend.model.MyOrder;

public interface OrderRepository extends JpaRepository<MyOrder, Integer> {

	@Query(value = "SELECT * FROM my_order WHERE user_id = :userId", nativeQuery = true)
	List<MyOrder> getOrderByCustomerId(int userId);

	@Query(value = "SELECT b.book_id, b.name, b.price, b.mrp, b.details, b.author, b.rating, b.no_of_rating, b.image_url, m.order_id, m.user_id, m.quantity, m.total_cost, m.order_date FROM books b JOIN my_order m ON b.book_id = m.book_id WHERE user_id = :userId", nativeQuery = true)
	List<BookAndOrder> getBookWithOrder(int userId);
}
