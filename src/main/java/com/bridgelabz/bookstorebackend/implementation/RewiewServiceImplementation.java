package com.bridgelabz.bookstorebackend.implementation;

import com.bridgelabz.bookstorebackend.model.Review;
import com.bridgelabz.bookstorebackend.dto.ReviewDTO;
import com.bridgelabz.bookstorebackend.repository.ReviewRepository;
import com.bridgelabz.bookstorebackend.service.BooksService;
import com.bridgelabz.bookstorebackend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewiewServiceImplementation implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    BooksService booksService;

    @Override
    public List<Review> getAllRewiewsByBook(int bookId) {
        return reviewRepository.findByBookId(bookId);
    }

    @Override
    public Review createReview(ReviewDTO reviewDTO) {
        Review review = new Review(reviewDTO);
        List<Review> ratingList = reviewRepository.findByBookId(reviewDTO.getBookId());
        int sum = ratingList.stream().mapToInt(Review::getRating).sum();
        sum += reviewDTO.getRating();
        int noOfRating = reviewRepository.findByBookId(reviewDTO.getBookId()).size();
        noOfRating++;
        double rating = sum/(double)noOfRating;
        booksService.updateRating(reviewDTO.getBookId(), rating, noOfRating);
        return reviewRepository.save(review);
    }
}
