package com.bridgelabz.bookstorebackend.controller;

import com.bridgelabz.bookstorebackend.model.Books;
import com.bridgelabz.bookstorebackend.dto.BookDTO;
import com.bridgelabz.bookstorebackend.dto.ResponseDTO;
import com.bridgelabz.bookstorebackend.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    BooksService booksService;

    @GetMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getAllBooks() {
        List<Books> booksList = null;
        booksList = booksService.getAllBooksData();
        ResponseDTO responseDTO = new ResponseDTO("Get call successful", booksList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getBokById(@PathVariable("id") int id) {
        Books books = booksService.getBookDataById((int) id);
        ResponseDTO responseDTO = new ResponseDTO("Get call for id successful", books);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createBookById(@RequestBody BookDTO bookDTO) {
        Books books = null;
        books = booksService.createBook(bookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created book dto", books);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateBookById(@PathVariable("id") int id, @RequestBody BookDTO bookDTO) {
        Books books = null;
        books = booksService.updateBookDetail(id, bookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated book dto", books);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}/qty/{qty}")
    public ResponseEntity<ResponseDTO> updateBookQuantity(@PathVariable("id") int id, @PathVariable("qty") int qty) {
        Books books = null;
        books = booksService.updateBookQuantity(id, qty);
        ResponseDTO responseDTO = new ResponseDTO("Created book dto", books);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteBookById(@PathVariable("id") int id) {
        booksService.deteleBookDataById((int) id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted book of id ", id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


}
