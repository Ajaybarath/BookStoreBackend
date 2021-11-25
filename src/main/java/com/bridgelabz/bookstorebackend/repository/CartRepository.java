package com.bridgelabz.bookstorebackend.repository;

import com.bridgelabz.bookstorebackend.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    Cart findByUserId(int id);
}
