package com.bridgelabz.bookstorebackend.controller;

import com.bridgelabz.bookstorebackend.data.BooksData;
import com.bridgelabz.bookstorebackend.dto.ResponseDTO;
import com.bridgelabz.bookstorebackend.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/wishlist")
public class WishlistController {

    @Autowired
    WishlistService wishlistService;

    @GetMapping("get/{userId}")
    public ResponseEntity<ResponseDTO> getWishListByUserId(@PathVariable("userId") int userId) {
        List<BooksData> wishList = wishlistService.getWishlistByUserId(userId);
        ResponseDTO responseDTO = new ResponseDTO("get books from wish list", wishList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/{userId}/addBooks/{bookId}")
    public ResponseEntity<ResponseDTO> addBooksToWishList(@PathVariable("userId") int userId, @PathVariable("bookId") int bookId) {
        wishlistService.addBookToWishList(bookId, userId);
        ResponseDTO responseDTO = new ResponseDTO("book added to wish list", bookId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

    @PostMapping("/{userId}/removeBooks/{bookId}")
    public ResponseEntity<ResponseDTO> removeBooksFromWishList(@PathVariable("userId") int userId, @PathVariable("bookId") int bookId) {
        wishlistService.removeBooksFromWishlist(bookId, userId);
        ResponseDTO responseDTO = new ResponseDTO("book removed from wish list", bookId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

}
