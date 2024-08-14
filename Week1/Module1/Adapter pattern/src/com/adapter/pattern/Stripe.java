package com.adapter.pattern;

public class Stripe {
    public void sendPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe.");
    }
}
