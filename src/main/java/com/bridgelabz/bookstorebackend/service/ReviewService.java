package com.bridgelabz.bookstorebackend.service;

import com.bridgelabz.bookstorebackend.model.Review;
import com.bridgelabz.bookstorebackend.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {
    List<Review> getAllRewiewsByBook(int bookId);

    Review createReview(ReviewDTO reviewDTO);
}
