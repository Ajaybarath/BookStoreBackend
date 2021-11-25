package com.bridgelabz.bookstorebackend.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
public
@Getter
@Setter
class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cartItem_id")
    int id;

    int quantity;

    int price;

    int total;

    int bookId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cart_id", nullable = false)
    @JsonIgnoreProperties("cartItems")
    Cart cart;

    public CartItem(int quantity, int bookId, int price, int total) {
        this.quantity = quantity;
        this.price = price;
        this.bookId = bookId;
        this.total = total;
    }

    public CartItem() {

    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", total=" + total +
                ", bookId=" + bookId +
                '}';
    }
}
