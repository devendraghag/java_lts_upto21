package com.example.designpattern.structural;

// A facade hides the order of calls needed across inventory, payment, and shipping.
public class Facade02OrderWorkflowDemo {
    static class Inventory { boolean reserve(String item) { System.out.println("Reserved " + item); return true; } }
    static class Payment { void charge() { System.out.println("Payment charged"); } }
    static class Shipping { void ship(String item) { System.out.println("Shipping " + item); } }

    static class OrderFacade {
        private final Inventory inventory = new Inventory();
        private final Payment payment = new Payment();
        private final Shipping shipping = new Shipping();
        void place(String item) {
            if (inventory.reserve(item)) { payment.charge(); shipping.ship(item); }
        }
    }

    public static void main(String[] args) {
        new OrderFacade().place("Keyboard");
    }
}
