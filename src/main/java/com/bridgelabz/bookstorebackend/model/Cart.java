package com.bridgelabz.bookstorebackend.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
@Getter
@Setter
public @ToString class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cart_id")
	int id;

	int userId;

	int quantity;

	int totalPrice;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	List<CartItem> cartItems = new ArrayList<>();

	public Cart(int userID, int quantity, int totalPrice) {
		this.userId = userID;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	public void addCartItem(CartItem cartItem) {
		cartItems.add(cartItem);
	}

	public void removeCartItem(CartItem cartItem) {
		cartItems.remove(cartItem);
	}

	public void addQuantity(Books books, int quantity) {
		if (cartItems.stream().anyMatch(it -> it.getBookId() == books.getId())) {
			cartItems.forEach((cartItem -> {
				if (cartItem.getBookId() == books.getId()) {
					int qty = cartItem.getQuantity();
					qty += quantity;
					cartItem.setQuantity(qty);
					cartItem.setTotal(qty * cartItem.getPrice());
					this.quantity += quantity;
					this.totalPrice += quantity * cartItem.getPrice();
				}
			}));
		} else {
			CartItem cartItem = new CartItem(quantity, books.getId(), books.getPrice(), books.getPrice());
			this.quantity += quantity;
			this.totalPrice += quantity * cartItem.getPrice();
			this.addCartItem(cartItem);
			cartItem.setCart(this);
		}
	}

	public void decreaseQuantity(Books books, int quantity) {
		if (cartItems.stream().anyMatch(it -> it.getBookId() == books.getId())) {
			cartItems.forEach((cartItem -> {
				if (cartItem.getBookId() == books.getId()) {
					int qty = cartItem.getQuantity();
					qty -= quantity;
					cartItem.setQuantity(qty);
					cartItem.setTotal(qty * cartItem.getPrice());

					this.quantity -= quantity;
					this.totalPrice -= quantity * cartItem.getPrice();
				}
			}));
		}

		cartItems.removeIf(ob -> ob.getQuantity() <= 0);

	}

	public Cart() {
	}

}
