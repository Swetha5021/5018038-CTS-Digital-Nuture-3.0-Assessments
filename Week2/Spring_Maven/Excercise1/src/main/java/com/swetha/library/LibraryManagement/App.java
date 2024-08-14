package com.swetha.library.LibraryManagement;

import com.library.service.BookService;
import com.library.repository.BookRepository;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = (BookService) context.getBean("bookService");
        
        BookRepository bookRepo = (BookRepository) context.getBean("bookRepository");
        
        bookService.performService();
        bookRepo.save();
    }
}

