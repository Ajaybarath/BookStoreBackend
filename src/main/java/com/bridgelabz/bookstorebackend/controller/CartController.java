package com.bridgelabz.bookstorebackend.controller;

import com.bridgelabz.bookstorebackend.model.Cart;
import com.bridgelabz.bookstorebackend.dto.CartItemDTO;
import com.bridgelabz.bookstorebackend.dto.ResponseDTO;
import com.bridgelabz.bookstorebackend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/bookstore/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/{userID}/get")
    public ResponseEntity<ResponseDTO> getCartItemsList(@PathVariable("userID") int userID) {
        Cart cart = cartService.getCartItemList(userID);
        ResponseDTO responseDTO = new ResponseDTO("Getting cart items", cart);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/{userID}/addItems")
    public ResponseEntity<ResponseDTO> addItemsToCart(@PathVariable("userID") int userID, @RequestBody CartItemDTO cartItemDTO) {
        Cart cart = cartService.addItemToCart(userID, cartItemDTO);
        ResponseDTO responseDTO = new ResponseDTO("Adding item to cart", cartItemDTO);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/{userID}/removeItems")
    public ResponseEntity<ResponseDTO> removeItemsFromCart(@PathVariable("userID") int userID, @RequestBody CartItemDTO cartItemDTO) {
        Cart cart = cartService.removeItemFromCart(userID, cartItemDTO);
        ResponseDTO responseDTO = new ResponseDTO("Removing item from cart", cartItemDTO);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
