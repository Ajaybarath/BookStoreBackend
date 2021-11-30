package com.bridgelabz.bookstorebackend.service;

import com.bridgelabz.bookstorebackend.dto.CartDTO;
import com.bridgelabz.bookstorebackend.model.Cart;
import com.bridgelabz.bookstorebackend.dto.CartItemDTO;

import java.util.List;

public interface CartService {
    Cart addItemToCart(int userID, CartItemDTO cartItemDTO);

    Cart removeItemFromCart(int userID, CartItemDTO cartItemDTO);

    List<CartDTO> getCartItemList(int userID);
}
