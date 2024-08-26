package com.swetha.BookStoreAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Data;


@Data
@Entity
public class Book {
    @Id
    private int id;

    private String title;
    private String author;
    private double price;
    private String isbn;

    @Version
    private int version;
    
    public Book() {
    }

	public Book(int id, String title, String author, double price, String isbn, int version) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.isbn = isbn;
		this.version = version;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
    
}