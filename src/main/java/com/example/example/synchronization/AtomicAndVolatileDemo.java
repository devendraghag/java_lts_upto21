package com.example.synchronization;

import java.util.concurrent.atomic.AtomicInteger;

/** Demonstrates atomic updates and a volatile visibility flag. */
public class AtomicAndVolatileDemo {
    private static final class SharedState {
        private final AtomicInteger count = new AtomicInteger();
        private volatile boolean ready;
        private int message;
    }

    public static void main(String[] args) throws InterruptedException {
        SharedState state = new SharedState();
        Thread reader = new Thread(() -> {
            while (!state.ready) {
                Thread.onSpinWait();
            }
            System.out.println("Published message: " + state.message);
        });

        reader.start();
        state.message = 42;
        state.ready = true; // Volatile write publishes the preceding message write.
        reader.join();

        Thread first = new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                state.count.incrementAndGet();
            }
        });
        Thread second = new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                state.count.incrementAndGet();
            }
        });
        first.start();
        second.start();
        first.join();
        second.join();
        System.out.println("Atomic count: " + state.count.get());
    }
}
