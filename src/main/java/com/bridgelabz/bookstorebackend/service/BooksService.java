package com.bridgelabz.bookstorebackend.service;

import com.bridgelabz.bookstorebackend.data.BooksData;
import com.bridgelabz.bookstorebackend.dto.BookDTO;

import java.util.List;

public interface BooksService {
    BooksData createBook(BookDTO bookDTO);

    BooksData getBookDataById(int id);

    List<BooksData> getAllBooksData();

    void deteleBookDataById(int id);

    BooksData updateBookDetail(int id, BookDTO bookDTO);

    BooksData updateBookQuantity(int id, int qty);
}
