package com.example.synchronization;

/** Demonstrates limiting a critical section with a synchronized block. */
public class SynchronizedBlockDemo {
    private static final class Inventory {
        private final Object lock = new Object();
        private int units;

        private void add(int amount) {
            if (amount < 0) {
                throw new IllegalArgumentException("amount must not be negative");
            }
            synchronized (lock) {
                units += amount;
            }
        }

        private int units() {
            synchronized (lock) {
                return units;
            }
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.add(5);
        inventory.add(3);
        System.out.println("Inventory units: " + inventory.units());
    }
}
