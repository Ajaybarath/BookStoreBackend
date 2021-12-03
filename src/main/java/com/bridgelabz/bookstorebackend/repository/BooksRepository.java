package com.bridgelabz.bookstorebackend.repository;

import com.bridgelabz.bookstorebackend.model.Books;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BooksRepository extends JpaRepository<Books, Integer> {

	@Query(value = "SELECT * FROM books ORDER BY price ASC", nativeQuery = true)
	List<Books> sortBooksByPriceLowToHigh();

	@Query(value = "SELECT * FROM books ORDER BY price DESC", nativeQuery = true)
	List<Books> sortBooksByPriceHighToLow();
}
