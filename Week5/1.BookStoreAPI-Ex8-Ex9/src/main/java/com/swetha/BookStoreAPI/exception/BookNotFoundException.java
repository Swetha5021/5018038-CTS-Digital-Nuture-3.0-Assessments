package com.swetha.BookStoreAPI.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(int id) {
        super("Book with ID " + id + " not found");
    }
}
