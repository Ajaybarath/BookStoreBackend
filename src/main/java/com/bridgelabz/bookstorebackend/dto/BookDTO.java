package com.bridgelabz.bookstorebackend.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;


public @Data
@ToString
class BookDTO {

    String name;
    int price;
    int mrp;
    String details;
    String author;
    int quantity;
    List<String> imageUrl;

}
