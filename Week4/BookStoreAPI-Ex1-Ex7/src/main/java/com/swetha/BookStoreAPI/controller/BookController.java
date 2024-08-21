package com.swetha.BookStoreAPI.controller;

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

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> bookList = new ArrayList<>();

    // Using @ResponseStatus
    
    /*
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable int id) {
        return bookList.stream().filter(book -> book.getId() == id)
                .findFirst().orElseThrow(() -> new BookNotFoundException(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        bookList.add(book);
        return book;
    }*/

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        for (Book book : bookList) {
            if (book.getId() == id) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setPrice(updatedBook.getPrice());
                book.setIsbn(updatedBook.getIsbn());
                return book;
            }
        }
        throw new BookNotFoundException(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int id) {
        boolean removed = bookList.removeIf(book -> book.getId() == id);
        if (!removed) {
            throw new BookNotFoundException(id);
        }
    }
    
    /*  Adding custom headers to the response using ResponseEntity:
    
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Book book = bookList.stream().filter(b -> b.getId() == id)
                .findFirst().orElseThrow(() -> new BookNotFoundException(id));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Book-Details");
        return new ResponseEntity<>(book, headers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        bookList.add(book);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Book-Creation");
        return new ResponseEntity<>(book, headers, HttpStatus.CREATED);
    }

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
    */
    
    //Excercise 7
    //Using the Mapper:
    
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable int id) {
        Book book = bookList.stream().filter(b -> b.getId() == id)
                .findFirst().orElseThrow(() -> new BookNotFoundException(id));
        BookDTO bookDTO = BookMapper.INSTANCE.bookToBookDTO(book);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Book-Details");
        return new ResponseEntity<>(bookDTO, headers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO) {
        Book book = BookMapper.INSTANCE.bookDTOToBook(bookDTO);
        bookList.add(book);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Book-Creation");
        return new ResponseEntity<>(bookDTO, headers, HttpStatus.CREATED);
    }
}
//Using @ResponseStatus
//@ResponseStatus(HttpStatus.NOT_FOUND)
//class BookNotFoundException extends RuntimeException {
//    public BookNotFoundException(int id) {
//        super("Book with ID " + id + " not found");
//    }
//}