package com.library.management;

import java.util.Arrays;

public class Library {
    private final Book[] books;
    private int count;

    public Library(int size) {
        books = new Book[size];
        count = 0;
    }

    // Add a book
    public void addBook(Book book) {
        if (count < books.length) {
            books[count++] = book;
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    // Linear search to find books by title
    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    // Binary search to find books by title (assuming the list is sorted)
    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = count - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid];
            }

            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // Sort books by title (for binary search)
    public void sortBooksByTitle() {
        Arrays.sort(books, 0, count, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
    }
}

