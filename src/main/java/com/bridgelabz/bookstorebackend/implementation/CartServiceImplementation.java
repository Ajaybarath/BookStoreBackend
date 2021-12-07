package com.bridgelabz.bookstorebackend.implementation;

import com.bridgelabz.bookstorebackend.dto.CartDTO;
import com.bridgelabz.bookstorebackend.model.Books;
import com.bridgelabz.bookstorebackend.model.Cart;
import com.bridgelabz.bookstorebackend.dto.CartItemDTO;
import com.bridgelabz.bookstorebackend.repository.CartItemRepository;
import com.bridgelabz.bookstorebackend.repository.CartRepository;
import com.bridgelabz.bookstorebackend.service.BooksService;
import com.bridgelabz.bookstorebackend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImplementation implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    BooksService booksService;

    @Override
    public Cart addItemToCart(int userID, CartItemDTO cartItemDTO) {
        Books book = booksService.getBookDataById(cartItemDTO.getBookId());
        Cart cart = cartRepository.findByUserId(userID);
        if (cart == null) {
            cart = new Cart(userID, 0, 0);
        }

        cart.addQuantity(book, cartItemDTO.getQuantity());

        return cartRepository.save(cart);
    }

    @Override
    public Cart removeItemFromCart(int userID, CartItemDTO cartItemDTO) {
        Books book = booksService.getBookDataById(cartItemDTO.getBookId());
        Cart cart = cartRepository.findByUserId(userID);

        cart.decreaseQuantity(book, cartItemDTO.getQuantity());

        return cartRepository.save(cart);
    }

    @Override
    public List<CartDTO> getCartItemList(int userID) {
        Cart cart = cartRepository.findByUserId(userID);
        List<CartDTO> cartItems = new ArrayList<>();
        if (cart.getCartItems().size() > 0) {
            cart.getCartItems().forEach(bk -> {
                cartItems.add(new CartDTO(booksService.getBookDataById(bk.getBookId()), bk.getQuantity(), bk.getTotal()));
            });
        }
        return cartItems;
    }
}
