package com.proxy.pattern;

public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // Images will be loaded from the remote server only when display() is called
        System.out.println("Displaying first image:");
        image1.display();

        System.out.println("\nDisplaying second image:");
        image2.display();

        System.out.println("\nDisplaying first image again:");
        image1.display(); // This time, the image will not be loaded again
    }
}
