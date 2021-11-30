package com.bridgelabz.bookstorebackend.dto;

import com.bridgelabz.bookstorebackend.model.Books;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

public  @Data
@ToString
@AllArgsConstructor
class CartDTO {

    Books books;
    int quantity;
    int total;

}
