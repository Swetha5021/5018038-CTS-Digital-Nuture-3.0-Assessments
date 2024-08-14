package com.library.management;

public class Main {
    public static void main(String[] args) {
        Library library = new Library(10);

        // Adding books
        library.addBook(new Book("B001", "Java Programming", "Author A"));
        library.addBook(new Book("B002", "Data Structures", "Author B"));
        library.addBook(new Book("B003", "Algorithms", "Author C"));

        // Linear search
        System.out.println("Linear Search:");
        Book book = library.linearSearchByTitle("Data Structures");
        if (book != null) {
            System.out.println("Found book: " + book.getTitle() + " by " + book.getAuthor());
        } else {
            System.out.println("Book not found.");
        }

        // Binary search
        library.sortBooksByTitle();
        System.out.println("\nBinary Search:");
        book = library.binarySearchByTitle("Data Structures");
        if (book != null) {
            System.out.println("Found book: " + book.getTitle() + " by " + book.getAuthor());
        } else {
            System.out.println("Book not found.");
        }
    }
}
