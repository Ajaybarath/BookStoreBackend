package com.bridgelabz.bookstorebackend.service;

import com.bridgelabz.bookstorebackend.model.Books;
import com.bridgelabz.bookstorebackend.dto.BookDTO;

import java.util.List;

public interface BooksService {
    Books createBook(BookDTO bookDTO);

    Books getBookDataById(int id);

    List<Books> getAllBooksData();

    void deteleBookDataById(int id);

    Books updateBookDetail(int id, BookDTO bookDTO);

    Books updateBookQuantity(int id, int qty);
}
