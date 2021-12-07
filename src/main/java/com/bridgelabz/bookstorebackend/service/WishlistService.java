package com.bridgelabz.bookstorebackend.service;

import com.bridgelabz.bookstorebackend.model.Books;
import com.bridgelabz.bookstorebackend.model.Wishlist;

import java.util.List;

public interface WishlistService {
    Wishlist addBookToWishList(int bookId, int userId);

    List<Books> getWishlistByUserId(int userId);

    Wishlist removeBooksFromWishlist(int bookId, int userId);
}
