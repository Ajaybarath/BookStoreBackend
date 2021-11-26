package com.bridgelabz.bookstorebackend.service;

import com.bridgelabz.bookstorebackend.model.Cart;
import com.bridgelabz.bookstorebackend.dto.CartItemDTO;

public interface CartService {
    Cart addItemToCart(int userID, CartItemDTO cartItemDTO);

    Cart removeItemFromCart(int userID, CartItemDTO cartItemDTO);

    Cart getCartItemList(int userID);
}
