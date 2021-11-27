package com.bridgelabz.bookstorebackend.controller;

import com.bridgelabz.bookstorebackend.model.Review;
import com.bridgelabz.bookstorebackend.dto.ResponseDTO;
import com.bridgelabz.bookstorebackend.dto.ReviewDTO;
import com.bridgelabz.bookstorebackend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookstore/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/get/{bookId}")
    public ResponseEntity<ResponseDTO> getAllRewiewsByBook(@PathVariable("bookId") int bookId) {
        List<Review> reviewList = reviewService.getAllRewiewsByBook(bookId);
        ResponseDTO responseDTO = new ResponseDTO("Get call successful", reviewList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create/userReview/")
    public ResponseEntity<ResponseDTO> createReviewByBookId(@RequestBody ReviewDTO reviewDTO) {
        Review review = reviewService.createReview(reviewDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created book dto", review);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
