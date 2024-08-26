package com.swetha.BookStoreAPI.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swetha.BookStoreAPI.dto.BookDTO;
import com.swetha.BookStoreAPI.service.BookService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Autowired
    private ObjectMapper objectMapper;

    private BookDTO bookDTO;

    @BeforeEach
    void setUp() {
        bookDTO = new BookDTO();
        bookDTO.setId(1);
        bookDTO.setTitle("Sample Book");
        bookDTO.setAuthor("Author Name");
        bookDTO.setPrice(29.99);
        bookDTO.setIsbn("1234567890");
    }

    @Test
    void testGetBookById() throws Exception {
        when(bookService.getBookById(1)).thenReturn(bookDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/books/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Sample Book"));
    }
}