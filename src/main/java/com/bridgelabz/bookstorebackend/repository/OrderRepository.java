package com.bridgelabz.bookstorebackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.bookstorebackend.model.MyOrder;

public interface OrderRepository extends JpaRepository<MyOrder, Integer>{

	@Query(value = "SELECT * FROM my_order WHERE customer_id = :customerId", nativeQuery = true)
	List<MyOrder> getOrderByCustomerId(int customerId);

}
