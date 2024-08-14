Exercise 8: Implementing the Strategy Pattern
Scenario:
You are developing a payment system where different payment methods (e.g., Credit Card, PayPal) can be selected at runtime. Use the Strategy Pattern to achieve this.
Steps:
1.	Create a New Java Project:
o	Create a new Java project named StrategyPatternExample.
2.	Define Strategy Interface:
o	Create an interface PaymentStrategy with a method pay().
3.	Implement Concrete Strategies:
o	Create classes CreditCardPayment, PayPalPayment that implement PaymentStrategy.
4.	Implement Context Class:
o	Create a class PaymentContext that holds a reference to PaymentStrategy and a method to execute the strategy.
5.	Test the Strategy Implementation:
o	Create a test class to demonstrate selecting and using different payment strategies.
