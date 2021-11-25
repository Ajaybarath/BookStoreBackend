package com.bridgelabz.bookstorebackend.repository;

import com.bridgelabz.bookstorebackend.data.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByBookId(int id);
}
