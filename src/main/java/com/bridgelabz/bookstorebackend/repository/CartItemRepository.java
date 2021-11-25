package com.bridgelabz.bookstorebackend.repository;

import com.bridgelabz.bookstorebackend.data.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

}
