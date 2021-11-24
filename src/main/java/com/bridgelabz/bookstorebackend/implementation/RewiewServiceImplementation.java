package com.bridgelabz.bookstorebackend.implementation;

import com.bridgelabz.bookstorebackend.data.ReviewData;
import com.bridgelabz.bookstorebackend.dto.ReviewDTO;
import com.bridgelabz.bookstorebackend.repository.ReviewRepository;
import com.bridgelabz.bookstorebackend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Service
public class RewiewServiceImplementation implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public List<ReviewData> getAllRewiewsByBook(int bookId) {
        return reviewRepository.findByBookId(bookId);
    }

    @Override
    public ReviewData createReview(ReviewDTO reviewDTO) {
        ReviewData reviewData = new ReviewData(reviewDTO);
        return reviewRepository.save(reviewData);
    }
}
