package com.bridgelabz.bookstorebackend.repository;

import com.bridgelabz.bookstorebackend.data.BooksData;
import com.bridgelabz.bookstorebackend.data.WishlistData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistRepository extends JpaRepository<WishlistData, Integer> {

    WishlistData findByUserId(int id);
}
