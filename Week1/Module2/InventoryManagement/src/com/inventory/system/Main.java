package com.inventory.system;

public class Main {
    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        // Adding products
        Product product1 = new Product("P001", "Laptop", 10, 999.99);
        Product product2 = new Product("P002", "Smartphone", 20, 599.99);

        ims.addProduct(product1);
        ims.addProduct(product2);

        // Updating a product
        Product updatedProduct1 = new Product("P001", "Gaming Laptop", 8, 1299.99);
        ims.updateProduct("P001", updatedProduct1);

        // Deleting a product
        ims.deleteProduct("P002");

        // Retrieving a product
        Product retrievedProduct = ims.getProduct("P001");
        if (retrievedProduct != null) {
            System.out.println("Product ID: " + retrievedProduct.getProductId());
            System.out.println("Product Name: " + retrievedProduct.getProductName());
            System.out.println("Quantity: " + retrievedProduct.getQuantity());
            System.out.println("Price: $" + retrievedProduct.getPrice());
        } else {
            System.out.println("Product not found!");
        }
    }
}
