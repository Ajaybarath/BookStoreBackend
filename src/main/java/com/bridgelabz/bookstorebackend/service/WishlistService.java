package com.bridgelabz.bookstorebackend.service;

import com.bridgelabz.bookstorebackend.data.BooksData;
import com.bridgelabz.bookstorebackend.data.WishlistData;

import java.util.List;

public interface WishlistService {
    WishlistData addBookToWishList(int bookId, int userId);

    List<BooksData> getWishlistByUserId(int userId);

    WishlistData removeBooksFromWishlist(int bookId, int userId);
}
