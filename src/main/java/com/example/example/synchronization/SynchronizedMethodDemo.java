package com.example.synchronization;

/** Demonstrates mutual exclusion with a synchronized instance method. */
public class SynchronizedMethodDemo {
    private static final class Counter {
        private int value;

        public synchronized void increment() {
            value++;
        }

        private int value() {
            return value;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Runnable task = () -> {
            for (int i = 0; i < 100_000; i++) {
                counter.increment();
            }
        };

        Thread first = new Thread(task);
        Thread second = new Thread(task);
        first.start();
        second.start();
        first.join();
        second.join();

        System.out.println("Expected count: 200000");
        System.out.println("Actual count: " + counter.value());
    }
}
