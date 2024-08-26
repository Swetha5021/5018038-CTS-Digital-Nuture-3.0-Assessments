package com.swetha.BookStoreAPI.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.swetha.BookStoreAPI.model.Book;

@Mapper
public interface BookMapper {
	
	public static Book toEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPrice(bookDTO.getPrice());
        book.setIsbn(bookDTO.getIsbn());
        return book;
    }

    public static BookDTO toDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setPrice(book.getPrice());
        bookDTO.setIsbn(book.getIsbn());
        return bookDTO;
    }
    
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

 // Mapping single Book to BookDTO
    BookDTO bookToBookDTO(Book book);

    // Mapping single BookDTO to Book
    Book bookDTOToBook(BookDTO bookDTO);

    // Mapping List<Book> to List<BookDTO>
//    List<BookDTO> bookToBookDTOList(List<Book> books);
//
//    // Mapping List<BookDTO> to List<Book>
//    List<Book> bookDTOListToBookList(List<BookDTO> bookDTOs);
}
