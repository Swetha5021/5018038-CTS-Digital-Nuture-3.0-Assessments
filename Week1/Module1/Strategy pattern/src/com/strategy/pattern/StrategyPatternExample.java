package com.strategy.pattern;

public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        // Pay using Credit Card
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234567890123456", "John Doe", "123", "12/25");
        paymentContext.setPaymentStrategy(creditCardPayment);
        paymentContext.executePayment(100.00);

        // Pay using PayPal
        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com", "password123");
        paymentContext.setPaymentStrategy(payPalPayment);
        paymentContext.executePayment(200.00);
    }
}

