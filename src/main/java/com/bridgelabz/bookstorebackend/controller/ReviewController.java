package com.bridgelabz.bookstorebackend.controller;

import com.bridgelabz.bookstorebackend.data.ReviewData;
import com.bridgelabz.bookstorebackend.dto.ResponseDTO;
import com.bridgelabz.bookstorebackend.dto.ReviewDTO;
import com.bridgelabz.bookstorebackend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/get/{bookId}")
    public ResponseEntity<ResponseDTO> getAllRewiewsByBook(@PathVariable("bookId") int bookId) {
        List<ReviewData> reviewList = reviewService.getAllRewiewsByBook(bookId);
        ResponseDTO responseDTO = new ResponseDTO("Get call successful", reviewList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create/userReview/")
    public ResponseEntity<ResponseDTO> createReviewByBookId(@RequestBody ReviewDTO reviewDTO) {
        ReviewData reviewData = reviewService.createReview(reviewDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created book dto", reviewData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
