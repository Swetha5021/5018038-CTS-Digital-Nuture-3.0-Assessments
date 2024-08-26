package com.swetha.BookStoreAPI.service;

import java.util.List;

import com.swetha.BookStoreAPI.dto.BookDTO;

public interface BookService {
	BookDTO createBook(BookDTO bookDTO);
    BookDTO updateBook(int id, BookDTO bookDTO);
    void deleteBook(int id);
    BookDTO getBookById(int id);
    List<BookDTO> getAllBooks();
}
