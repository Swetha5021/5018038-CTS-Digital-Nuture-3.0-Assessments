package com.sorting.customer;

public class Main {
    public static void main(String[] args) {
        Order[] orders = {
                new Order("O001", "Alice", 250.75),
                new Order("O002", "Bob", 320.50),
                new Order("O003", "Charlie", 150.00),
                new Order("O004", "Diana", 450.25),
                new Order("O005", "Eve", 210.40)
        };

        // Bubble Sort
        System.out.println("Before Bubble Sort:");
        printOrders(orders);
        BubbleSort.bubbleSort(orders);
        System.out.println("After Bubble Sort:");
        printOrders(orders);

        // Resetting orders array for Quick Sort
        orders = new Order[]{
                new Order("O001", "Alice", 250.75),
                new Order("O002", "Bob", 320.50),
                new Order("O003", "Charlie", 150.00),
                new Order("O004", "Diana", 450.25),
                new Order("O005", "Eve", 210.40)
        };

        // Quick Sort
        System.out.println("Before Quick Sort:");
        printOrders(orders);
        QuickSort.quickSort(orders, 0, orders.length - 1);
        System.out.println("After Quick Sort:");
        printOrders(orders);
    }

    private static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order.getOrderId() + ": " + order.getCustomerName() + " - $" + order.getTotalPrice());
        }
        System.out.println();
    }
}
