package com.bridgelabz.bookstorebackend.repository;

import com.bridgelabz.bookstorebackend.data.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Integer> {
}
