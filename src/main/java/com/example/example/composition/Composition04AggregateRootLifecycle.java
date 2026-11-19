package com.example.composition;

import java.util.ArrayList;
import java.util.List;

/** An Order is the aggregate root and controls the lifecycle and invariants of its lines. */
public class Composition04AggregateRootLifecycle {
    public static void main(String[] args) {
        Order order = new Order("ORD-104");
        order.addItem("Book", 2, 12.50);
        order.addItem("Pen", 3, 1.25);
        order.printSummary();
    }
    private static final class Order {
        private final String id;
        private final List<OrderLine> lines = new ArrayList<>();
        private Order(String id) { this.id = id; }
        private void addItem(String name, int quantity, double unitPrice) {
            if (quantity <= 0 || unitPrice < 0) throw new IllegalArgumentException("Invalid order item");
            lines.add(new OrderLine(name, quantity, unitPrice));
        }
        private void printSummary() {
            lines.forEach(line -> System.out.println(line.quantity + " x " + line.name));
            double total = lines.stream().mapToDouble(line -> line.quantity * line.unitPrice).sum();
            System.out.printf("Order %s total: $%.2f%n", id, total);
        }
    }
    private static final class OrderLine {
        private final String name;
        private final int quantity;
        private final double unitPrice;
        private OrderLine(String name, int quantity, double unitPrice) {
            this.name = name; this.quantity = quantity; this.unitPrice = unitPrice;
        }
    }
}
