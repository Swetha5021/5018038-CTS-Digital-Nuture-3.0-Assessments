package com.swetha.BookStoreAPI.exception;


public class InvalidBookDataException extends RuntimeException {
    public InvalidBookDataException(String message) {
        super(message);
    }
}