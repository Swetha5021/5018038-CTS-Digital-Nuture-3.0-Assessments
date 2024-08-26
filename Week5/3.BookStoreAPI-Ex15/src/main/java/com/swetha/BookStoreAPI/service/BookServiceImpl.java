package com.swetha.BookStoreAPI.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swetha.BookStoreAPI.dto.BookDTO;
import com.swetha.BookStoreAPI.dto.BookMapper;
import com.swetha.BookStoreAPI.model.Book;
import com.swetha.BookStoreAPI.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        Book book = BookMapper.toEntity(bookDTO);
        Book savedBook = bookRepository.save(book);
        return BookMapper.toDTO(savedBook);
    }

    @Override
    public BookDTO updateBook(int id, BookDTO bookDTO) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setTitle(bookDTO.getTitle());
            book.setAuthor(bookDTO.getAuthor());
            book.setPrice(bookDTO.getPrice());
            book.setIsbn(bookDTO.getIsbn());
            Book updatedBook = bookRepository.save(book);
            return BookMapper.toDTO(updatedBook);
        }
        return null;
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDTO getBookById(int id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        return bookOptional.map(BookMapper::toDTO).orElse(null);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(BookMapper::toDTO).collect(Collectors.toList());
    }
}