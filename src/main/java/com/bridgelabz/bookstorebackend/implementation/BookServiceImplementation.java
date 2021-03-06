package com.bridgelabz.bookstorebackend.implementation;

import com.bridgelabz.bookstorebackend.model.Books;
import com.bridgelabz.bookstorebackend.dto.BookDTO;
import com.bridgelabz.bookstorebackend.exception.BooksException;
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
	public Books createBook(BookDTO bookDTO) {
		Books books = new Books(bookDTO);
		return booksRepository.save(books);
	}

	@Override
	public Books getBookDataById(int id) {
		return booksRepository.findById(id).orElseThrow(() -> new BooksException("Books not found"));
	}

	@Override
	public List<Books> getAllBooksData() {
		return booksRepository.findAll();
	}

	@Override
	public void deteleBookDataById(int id) {
		Books books = this.getBookDataById(id);
		booksRepository.delete(books);
	}

	@Override
	public Books updateBookDetail(int id, BookDTO bookDTO) {
		Books books = this.getBookDataById(id);
		books.update(bookDTO);
		return booksRepository.save(books);
	}

	@Override
	public Books updateBookQuantity(int id, int qty) {
		Books books = this.getBookDataById(id);
		books.updateQuantity(qty);
		return booksRepository.save(books);
	}

	@Override
	public Books updateRating(int id, double rating, int noOfRating) {
		Books books = this.getBookDataById(id);
		books.updateRating(rating, noOfRating);
		return booksRepository.save(books);
	}

	@Override
	public List<Books> sortBooksByPriceLowToHigh() {
		List<Books> sortedBooksByPrice = booksRepository.sortBooksByPriceLowToHigh();
		return sortedBooksByPrice;
	}

	@Override
	public List<Books> sortBooksByPriceHighToLow() {
		List<Books> sortedBooksByPrice = booksRepository.sortBooksByPriceHighToLow();
		return sortedBooksByPrice;
	}

	@Override
	public List<Books> getAllBooksByName(String name) {
		List<Books> books = booksRepository.getAllBooksByName(name);
		return books;
	}

}
