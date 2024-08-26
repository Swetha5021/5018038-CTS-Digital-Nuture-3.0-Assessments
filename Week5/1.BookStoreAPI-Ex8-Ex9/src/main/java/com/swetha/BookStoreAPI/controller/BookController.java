package com.swetha.BookStoreAPI.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.swetha.BookStoreAPI.dto.BookDTO;
import com.swetha.BookStoreAPI.dto.BookMapper;
import com.swetha.BookStoreAPI.exception.BookNotFoundException;
import com.swetha.BookStoreAPI.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> bookList = new ArrayList<>();
    
    // Get a single book by ID with HATEOAS links
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<BookDTO>> getBookById(@PathVariable int id) {
        Book book = bookList.stream().filter(b -> b.getId() == id)
                .findFirst().orElseThrow(() -> new BookNotFoundException(id));
        BookDTO bookDTO = BookMapper.INSTANCE.bookToBookDTO(book);

        // Add HATEOAS links
        EntityModel<BookDTO> resource = EntityModel.of(bookDTO);
        Link selfLink = linkTo(methodOn(BookController.class).getBookById(id)).withSelfRel();
        Link allBooksLink = linkTo(methodOn(BookController.class).getAllBooks()).withRel("all-books");
        resource.add(selfLink, allBooksLink);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Book-Details");
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

    // Get all books with HATEOAS links
    @GetMapping
    public ResponseEntity<List<EntityModel<BookDTO>>> getAllBooks() {
        List<EntityModel<BookDTO>> booksWithLinks = bookList.stream().map(book -> {
            BookDTO bookDTO = BookMapper.INSTANCE.bookToBookDTO(book);
            EntityModel<BookDTO> resource = EntityModel.of(bookDTO);
            Link selfLink = linkTo(methodOn(BookController.class).getBookById(book.getId())).withSelfRel();
            resource.add(selfLink);
            return resource;
        }).collect(Collectors.toList());

        return new ResponseEntity<>(booksWithLinks, HttpStatus.OK);
    }
    
    // Create a new book
    @PostMapping
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO) {
        Book book = BookMapper.INSTANCE.bookDTOToBook(bookDTO);
        bookList.add(book);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Book-Creation");
        return new ResponseEntity<>(bookDTO, headers, HttpStatus.CREATED);
    }

//		Without HATEOAS
//    // Get a single book by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<BookDTO> getBookById(@PathVariable int id) {
//        Book book = bookList.stream().filter(b -> b.getId() == id)
//                .findFirst().orElseThrow(() -> new BookNotFoundException(id));
//        BookDTO bookDTO = BookMapper.INSTANCE.bookToBookDTO(book);
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Custom-Header", "Book-Details");
//        return new ResponseEntity<>(bookDTO, headers, HttpStatus.OK);
//    }
//
//
//    // Get all books
//    @GetMapping
//    public ResponseEntity<List<BookDTO>> getAllBooks() {
//        List<BookDTO> bookDTOs = new ArrayList<>();
//        for (Book book : bookList) {
//            bookDTOs.add(BookMapper.INSTANCE.bookToBookDTO(book));
//        }
//        return new ResponseEntity<>(bookDTOs, HttpStatus.OK);
//    }
    
    // Update an existing book
    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable int id, @RequestBody BookDTO bookDTO) {
        Book book = bookList.stream().filter(b -> b.getId() == id)
                .findFirst().orElseThrow(() -> new BookNotFoundException(id));
        
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPrice(bookDTO.getPrice());
        book.setIsbn(bookDTO.getIsbn());
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Book-Update");
        return new ResponseEntity<>(BookMapper.INSTANCE.bookToBookDTO(book), headers, HttpStatus.OK);
    }

    // Delete a book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        boolean removed = bookList.removeIf(book -> book.getId() == id);
        if (!removed) {
            throw new BookNotFoundException(id);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Book-Deletion");
        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }
}