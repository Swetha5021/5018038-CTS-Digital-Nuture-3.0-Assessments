package com.swetha.BookStoreAPI.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.swetha.BookStoreAPI.BookStoreApiApplication;
import com.swetha.BookStoreAPI.dto.BookDTO;
import com.swetha.BookStoreAPI.dto.BookMapper;
import com.swetha.BookStoreAPI.model.Book;
import com.swetha.BookStoreAPI.repository.BookRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class BookstoreApiIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    private BookDTO bookDTO;

    @BeforeEach
    void setUp() {
        bookDTO = new BookDTO();
        bookDTO.setTitle("Integration Testing with Spring");
        bookDTO.setAuthor("John Doe");
        bookDTO.setPrice(45.99);
        bookDTO.setIsbn("1234567890123");
    }

    @Test
    void testCreateBook() throws Exception {
        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Integration Testing with Spring\",\"author\":\"John Doe\",\"price\":45.99,\"isbn\":\"1234567890123\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Integration Testing with Spring"));
    }

    @Test
    void testGetBookById() throws Exception {
        // Convert DTO to Entity
        Book bookEntity = BookMapper.toEntity(bookDTO);
        
        // Pre-saving the entity to the repository
        Book savedBook = bookRepository.save(bookEntity);

        mockMvc.perform(get("/books/" + savedBook.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Integration Testing with Spring"));
    }

}