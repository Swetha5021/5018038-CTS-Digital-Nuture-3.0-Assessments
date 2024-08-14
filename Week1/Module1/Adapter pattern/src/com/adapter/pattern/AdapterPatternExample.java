package com.adapter.pattern;

public class AdapterPatternExample {
    public static void main(String[] args) {
        // Create instances of each payment gateway
        PayPal payPal = new PayPal();
        Stripe stripe = new Stripe();
        Square square = new Square();

        // Create adapter instances for each payment gateway
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPal);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripe);
        PaymentProcessor squareAdapter = new SquareAdapter(square);

        // Process payments using the adapters
        System.out.println("Using PayPal Adapter:");
        payPalAdapter.processPayment(100.00);

        System.out.println("\nUsing Stripe Adapter:");
        stripeAdapter.processPayment(200.00);

        System.out.println("\nUsing Square Adapter:");
        squareAdapter.processPayment(300.00);
    }
}

