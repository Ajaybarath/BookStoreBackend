package com.bridgelabz.bookstorebackend.dto;

import lombok.Data;
import lombok.ToString;

public @Data
@ToString
class ReviewDTO {

    int userId;
    int bookId;
    int rating;
    String review;

}
