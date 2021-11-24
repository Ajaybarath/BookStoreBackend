package com.bridgelabz.bookstorebackend.implementation;

import com.bridgelabz.bookstorebackend.data.BooksData;
import com.bridgelabz.bookstorebackend.dto.BookDTO;
import com.bridgelabz.bookstorebackend.exception.EmployeeException;
import com.bridgelabz.bookstorebackend.repository.BooksRepository;
import com.bridgelabz.bookstorebackend.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplementation implements BooksService {

    @Autowired
    BooksRepository booksRepository;

    @Override
    public BooksData createBook(BookDTO bookDTO) {
        BooksData booksData = new BooksData(bookDTO);
        return booksRepository.save(booksData);
    }

    @Override
    public BooksData getBookDataById(int id) {
        return booksRepository.findById(id).orElseThrow(() -> new EmployeeException("Employee not found"));
    }

    @Override
    public List<BooksData> getAllBooksData() {
        return booksRepository.findAll();
    }

    @Override
    public void deteleBookDataById(int id) {
        BooksData booksData = this.getBookDataById(id);
        booksRepository.delete(booksData);
    }

    @Override
    public BooksData updateBookDetail(int id, BookDTO bookDTO) {
        BooksData booksData = this.getBookDataById(id);
        booksData.update(bookDTO);
        return booksRepository.save(booksData);
    }

    @Override
    public BooksData updateBookQuantity(int id, int qty) {
        BooksData booksData = this.getBookDataById(id);
        booksData.updateQuantity(qty);
        return booksRepository.save(booksData);
    }
}
