package com.swetha.BookStoreAPI.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.swetha.BookStoreAPI.dto.BookDTO;
import com.swetha.BookStoreAPI.dto.BookMapper;
import com.swetha.BookStoreAPI.exception.BookNotFoundException;
import com.swetha.BookStoreAPI.model.Book;
import com.swetha.BookStoreAPI.service.MetricsService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final MetricsService metricsService;
    private List<Book> bookList = new ArrayList<>();
    
    public BookController(MetricsService metricsService) {
        this.metricsService = metricsService;
    }
    
    // Create a new book (consumes JSON or XML, produces JSON or XML)
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
                 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        Book book = BookMapper.INSTANCE.bookDTOToBook(bookDTO);
        bookList.add(book);
        metricsService.incrementBookCreationCounter(); // Increment custom metric
        return ResponseEntity.ok(bookDTO);
    }
    
    // Get a single book by ID with content negotiation support
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<BookDTO> getBookById(@PathVariable int id) {
        Book book = bookList.stream().filter(b -> b.getId() == id)
                .findFirst().orElseThrow(() -> new BookNotFoundException(id));
        BookDTO bookDTO = BookMapper.INSTANCE.bookToBookDTO(book);
        return ResponseEntity.ok(bookDTO);
    }

    // Get all books with content negotiation support
//    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public ResponseEntity<List<BookDTO>> getAllBooks() {
//        List<BookDTO> books = BookMapper.INSTANCE.bookToBookDTOList(bookList);
//        return ResponseEntity.ok(books);
//    }

}