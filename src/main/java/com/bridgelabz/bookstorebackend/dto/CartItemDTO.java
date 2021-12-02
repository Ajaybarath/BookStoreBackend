package com.bridgelabz.bookstorebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

public
@Data
@ToString
@AllArgsConstructor
class CartItemDTO {

    int userId;
    int bookId;
    int quantity;
}
