package com.bridgelabz.bookstorebackend.service;

import com.bridgelabz.bookstorebackend.data.ReviewData;
import com.bridgelabz.bookstorebackend.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {
    List<ReviewData> getAllRewiewsByBook(int bookId);

    ReviewData createReview(ReviewDTO reviewDTO);
}
