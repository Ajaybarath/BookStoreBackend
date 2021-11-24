package com.bridgelabz.bookstorebackend.repository;

import com.bridgelabz.bookstorebackend.data.ReviewData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewData, Integer> {
    List<ReviewData> findByBookId(int id);
}
