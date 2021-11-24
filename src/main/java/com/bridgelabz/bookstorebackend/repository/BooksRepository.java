package com.bridgelabz.bookstorebackend.repository;

import com.bridgelabz.bookstorebackend.data.BooksData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<BooksData, Integer> {
}
