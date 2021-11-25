package com.bridgelabz.bookstorebackend.implementation;

import com.bridgelabz.bookstorebackend.data.Review;
import com.bridgelabz.bookstorebackend.dto.ReviewDTO;
import com.bridgelabz.bookstorebackend.repository.ReviewRepository;
import com.bridgelabz.bookstorebackend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewiewServiceImplementation implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllRewiewsByBook(int bookId) {
        return reviewRepository.findByBookId(bookId);
    }

    @Override
    public Review createReview(ReviewDTO reviewDTO) {
        Review review = new Review(reviewDTO);
        return reviewRepository.save(review);
    }
}
