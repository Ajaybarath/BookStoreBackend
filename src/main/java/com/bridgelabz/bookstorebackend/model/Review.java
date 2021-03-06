package com.bridgelabz.bookstorebackend.model;

import com.bridgelabz.bookstorebackend.dto.ReviewDTO;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public @Data @ToString class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "review_id")
	int id;

	int userId;
	int bookId;
	int rating;
	String review;
	String name;

	public Review(ReviewDTO reviewDTO) {
		this.userId = reviewDTO.getUserId();
		this.bookId = reviewDTO.getBookId();
		this.rating = reviewDTO.getRating();
		this.review = reviewDTO.getReview();
		this.name = reviewDTO.getName();
	}

	public Review() {
	}
}
