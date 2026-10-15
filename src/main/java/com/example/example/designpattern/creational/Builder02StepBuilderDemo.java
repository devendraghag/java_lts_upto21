package com.example.designpattern.creational;

// Step Builder: the API guides callers through required choices in the right order.
public class Builder02StepBuilderDemo {
    static final class Order {
        private final String item;
        private final int quantity;
        private final String payment;

        private Order(String item, int quantity, String payment) {
            this.item = item; this.quantity = quantity; this.payment = payment;
        }

        public String toString() { return quantity + " x " + item + " paid by " + payment; }

        interface ItemStep { QuantityStep item(String item); }
        interface QuantityStep { PaymentStep quantity(int quantity); }
        interface PaymentStep { BuildStep payment(String payment); }
        interface BuildStep { Order build(); }

        private static class Steps implements ItemStep, QuantityStep, PaymentStep, BuildStep {
            private String item; private int quantity; private String payment;
            public QuantityStep item(String value) { item = value; return this; }
            public PaymentStep quantity(int value) { quantity = value; return this; }
            public BuildStep payment(String value) { payment = value; return this; }
            public Order build() { return new Order(item, quantity, payment); }
        }
        static ItemStep builder() { return new Steps(); }
    }

    public static void main(String[] args) {
        Order order = Order.builder().item("Notebook").quantity(2).payment("Card").build();
        System.out.println(order);
    }
}
