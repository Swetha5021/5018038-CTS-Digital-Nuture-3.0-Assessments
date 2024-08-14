package com.ecommerce.search;

import java.util.Arrays;

public class BinarySearch {
    public static Product binarySearch(Product[] products, String productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductId().compareTo(productId);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // Method to sort products based on productId
    public static void sortProducts(Product[] products) {
        Arrays.sort(products, (p1, p2) -> p1.getProductId().compareTo(p2.getProductId()));
    }
}
