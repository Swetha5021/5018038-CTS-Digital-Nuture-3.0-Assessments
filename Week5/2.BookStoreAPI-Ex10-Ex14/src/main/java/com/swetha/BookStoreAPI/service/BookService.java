package com.swetha.BookStoreAPI.service;

import com.swetha.BookStoreAPI.dto.BookDTO;

public interface BookService {
	BookDTO getBookById(int id);
}
