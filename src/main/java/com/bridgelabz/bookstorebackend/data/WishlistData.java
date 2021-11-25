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
class WishlistData {

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
    List<BooksData> booksList = new ArrayList<>();

    public WishlistData(int userId) {
        this.userId = userId;
    }

    public void addBooks(BooksData booksData) {
        booksList.add(booksData);
//        booksData.getWishlist().add(this);
    }

    public void removeBooks(BooksData booksData) {
        booksList.remove(booksData);
//        booksData.getWishlist().remove(this);
    }

    public WishlistData() {
    }
}
