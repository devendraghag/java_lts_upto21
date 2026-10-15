package com.example.abstractclass;

/** Demonstrates a sealed abstract class with a closed set of direct subclasses. */
public class AbstractClass18SealedHierarchyDemo {
    public static void main(String[] args) {
        Payment[] payments = {new CardPayment(25.50), new CashPayment(12.00)};
        for (Payment payment : payments) {
            System.out.println(payment.description());
        }
    }

    private abstract sealed static class Payment permits CardPayment, CashPayment {
        private final double amount;

        protected Payment(double amount) {
            this.amount = amount;
        }

        protected double amount() {
            return amount;
        }

        public abstract String description();
    }

    private static final class CardPayment extends Payment {
        private CardPayment(double amount) {
            super(amount);
        }

        @Override
        public String description() {
            return "Card payment: " + amount();
        }
    }

    private static non-sealed class CashPayment extends Payment {
        private CashPayment(double amount) {
            super(amount);
        }

        @Override
        public String description() {
            return "Cash payment: " + amount();
        }
    }
}
