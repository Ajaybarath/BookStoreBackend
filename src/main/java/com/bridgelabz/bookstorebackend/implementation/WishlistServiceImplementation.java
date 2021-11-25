package com.bridgelabz.bookstorebackend.implementation;

import com.bridgelabz.bookstorebackend.data.BooksData;
import com.bridgelabz.bookstorebackend.data.WishlistData;
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
    public WishlistData addBookToWishList(int bookId, int userId) {
        BooksData booksData = booksService.getBookDataById(bookId);
        WishlistData wishlistData = wishlistRepository.findByUserId(userId);
        if (wishlistData == null) {
            wishlistData = new WishlistData(userId);
        }

        if (!wishlistData.getBooksList().contains(booksData)) {
            wishlistData.addBooks(booksData);
        }

        return wishlistRepository.save(wishlistData);

    }

    @Override
    public List<BooksData> getWishlistByUserId(int userId) {
        return wishlistRepository.findByUserId(userId).getBooksList();
    }

    @Override
    public WishlistData removeBooksFromWishlist(int bookId, int userId) {
        BooksData booksData = booksService.getBookDataById(bookId);
        WishlistData wishlistData = wishlistRepository.findByUserId(userId);
        if (wishlistData == null) {
            wishlistData = new WishlistData(userId);
        }

        wishlistData.removeBooks(booksData);
        return wishlistRepository.save(wishlistData);

    }
}
