package com.swetha.BookStoreAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swetha.BookStoreAPI.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
