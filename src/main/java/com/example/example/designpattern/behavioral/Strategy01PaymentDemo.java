package com.example.designpattern.behavioral;

// Strategy: choose one interchangeable payment behavior and pass it to the service.
public class Strategy01PaymentDemo {
    interface PaymentStrategy { void pay(int amount); }
    static class UpiPayment implements PaymentStrategy {
        public void pay(int amount) { System.out.println("Paid Rs " + amount + " using UPI"); }
    }
    static class CardPayment implements PaymentStrategy {
        public void pay(int amount) { System.out.println("Paid Rs " + amount + " using card"); }
    }
    static class Checkout {
        void pay(PaymentStrategy strategy, int amount) { strategy.pay(amount); }
    }

    public static void main(String[] args) {
        Checkout checkout = new Checkout();
        checkout.pay(new UpiPayment(), 500);
        checkout.pay(new CardPayment(), 800);
    }
}
