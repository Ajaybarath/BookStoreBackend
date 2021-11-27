package com.bridgelabz.bookstorebackend.repository;

import com.bridgelabz.bookstorebackend.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

}
