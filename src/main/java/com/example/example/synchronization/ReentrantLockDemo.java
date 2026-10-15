package com.example.synchronization;

import java.util.concurrent.locks.ReentrantLock;

/** Demonstrates explicit locking and releasing a lock in finally. */
public class ReentrantLockDemo {
    private static final class SafeCounter {
        private final ReentrantLock lock = new ReentrantLock();
        private int value;

        private void increment() {
            lock.lock();
            try {
                value++;
            } finally {
                lock.unlock();
            }
        }

        private int value() {
            lock.lock();
            try {
                return value;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        SafeCounter counter = new SafeCounter();
        counter.increment();
        counter.increment();
        System.out.println("Count: " + counter.value());
    }
}
