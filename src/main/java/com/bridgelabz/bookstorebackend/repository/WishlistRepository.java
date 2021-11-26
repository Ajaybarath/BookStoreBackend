package com.bridgelabz.bookstorebackend.repository;

import com.bridgelabz.bookstorebackend.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {

    Wishlist findByUserId(int id);
}
