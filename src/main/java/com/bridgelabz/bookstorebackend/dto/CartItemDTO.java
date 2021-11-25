package com.bridgelabz.bookstorebackend.dto;

import lombok.Data;
import lombok.ToString;

public
@Data
@ToString
class CartItemDTO {

    int userId;
    int bookId;
    int quantity;
}
