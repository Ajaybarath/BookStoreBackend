package com.bridgelabz.bookstorebackend.implementation;

import com.bridgelabz.bookstorebackend.data.Books;
import com.bridgelabz.bookstorebackend.data.Wishlist;
import com.bridgelabz.bookstorebackend.repository.WishlistRepository;
import com.bridgelabz.bookstorebackend.service.BooksService;
import com.bridgelabz.bookstorebackend.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistServiceImplementation implements WishlistService {

    @Autowired
    BooksService booksService;

    @Autowired
    WishlistRepository wishlistRepository;

    @Override
    public Wishlist addBookToWishList(int bookId, int userId) {
        Books books = booksService.getBookDataById(bookId);
        Wishlist wishlist = wishlistRepository.findByUserId(userId);
        if (wishlist == null) {
            wishlist = new Wishlist(userId);
        }

        if (!wishlist.getBooksList().contains(books)) {
            wishlist.addBooks(books);
        }

        return wishlistRepository.save(wishlist);

    }

    @Override
    public List<Books> getWishlistByUserId(int userId) {
        return wishlistRepository.findByUserId(userId).getBooksList();
    }

    @Override
    public Wishlist removeBooksFromWishlist(int bookId, int userId) {
        Books books = booksService.getBookDataById(bookId);
        Wishlist wishlist = wishlistRepository.findByUserId(userId);
        if (wishlist == null) {
            wishlist = new Wishlist(userId);
        }

        wishlist.removeBooks(books);
        return wishlistRepository.save(wishlist);

    }
}
