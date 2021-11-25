package com.bridgelabz.bookstorebackend.model;

import com.bridgelabz.bookstorebackend.dto.BookDTO;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public @Data
@ToString
class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    int id;

    String name;
    int price;
    int mrp;
    String details;
    String author;
    int quantity;

    @ElementCollection
    @CollectionTable(name = "bookImage", joinColumns = @JoinColumn(name = "imageId"))
    @Column(name = "imageUrl")
    List<String> imageUrl;

    public Books() {
    }

    public Books(BookDTO bookDTO) {
        this.name = bookDTO.getName();
        this.author = bookDTO.getAuthor();
        this.details = bookDTO.getDetails();
        this.price = bookDTO.getPrice();
        this.mrp = bookDTO.getMrp();
        this.quantity = bookDTO.getQuantity();
        this.imageUrl = bookDTO.getImageUrl();
    }

    public void update(BookDTO bookDTO) {
        this.name = bookDTO.getName();
        this.author = bookDTO.getAuthor();
        this.details = bookDTO.getDetails();
        this.price = bookDTO.getPrice();
        this.mrp = bookDTO.getMrp();
        this.quantity = bookDTO.getQuantity();
        this.imageUrl = bookDTO.getImageUrl();
    }

    public void updateQuantity(int qty) {
        this.quantity += qty;
    }
}
