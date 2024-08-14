package com.ecommerce.search;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Product("P001", "Laptop", "Electronics"),
                new Product("P002", "Smartphone", "Electronics"),
                new Product("P003", "Tablet", "Electronics"),
                new Product("P004", "Monitor", "Electronics"),
                new Product("P005", "Keyboard", "Accessories")
        };

        // Linear Search
        Product foundProduct = LinearSearch.linearSearch(products, "P003");
        if (foundProduct != null) {
            System.out.println("Linear Search: Found product - " + foundProduct.getProductName());
        } else {
            System.out.println("Linear Search: Product not found");
        }

        // Sorting products for binary search
        BinarySearch.sortProducts(products);

        // Binary Search
        foundProduct = BinarySearch.binarySearch(products, "P003");
        if (foundProduct != null) {
            System.out.println("Binary Search: Found product - " + foundProduct.getProductName());
        } else {
            System.out.println("Binary Search: Product not found");
        }
    }
}
