package com.bridgelabz.bookstorebackend.data;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "wishlists")
public @Data
@ToString
class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "wishlist_id")
    int id;

    int userId;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "wishlist_books",
            joinColumns = @JoinColumn(name = "wishlist_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    List<Books> booksList = new ArrayList<>();

    public Wishlist(int userId) {
        this.userId = userId;
    }

    public void addBooks(Books books) {
        booksList.add(books);
//        booksData.getWishlist().add(this);
    }

    public void removeBooks(Books books) {
        booksList.remove(books);
//        booksData.getWishlist().remove(this);
    }

    public Wishlist() {
    }
}
