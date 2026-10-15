package com.example.coupling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/**
 * Data coupling: the caller passes only the values the called method needs.
 */
public class CouplingType01Data {
    static class InventoryService {
        boolean hasStock(String productCode, int requestedQuantity) {
            System.out.println("Checking " + requestedQuantity + " of " + productCode);
            return requestedQuantity <= 5;
        }
    }

    static class OrderService {
        private final InventoryService inventory = new InventoryService();

        void placeOrder(String productCode, int quantity) {
            if (inventory.hasStock(productCode, quantity)) {
                System.out.println("Order accepted");
            } else {
                System.out.println("Not enough stock");
            }
        }
    }

    public static void main(String[] args) {
        new OrderService().placeOrder("PEN-4", 3);
    }
}
