package com.swetha.BookStoreAPI.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.swetha.BookStoreAPI.model.Book;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO bookToBookDTO(Book book);
    Book bookDTOToBook(BookDTO bookDTO);
}
