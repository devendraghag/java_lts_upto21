package com.example.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/** Compares synchronized, ReentrantLock, and AtomicInteger for shared counters. */
public class SynchronizationMechanismsDemo {
    private static final int WORKERS = 4;
    private static final int INCREMENTS = 5_000;

    public static void main(String[] args) throws Exception {
        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
        LockedCounter lockedCounter = new LockedCounter();
        AtomicInteger atomicCounter = new AtomicInteger();

        try (ExecutorService executor = Executors.newFixedThreadPool(WORKERS)) {
            Future<?>[] jobs = new Future<?>[WORKERS * 3];
            int index = 0;
            for (int i = 0; i < WORKERS; i++) {
                jobs[index++] = executor.submit(() -> increment(synchronizedCounter));
                jobs[index++] = executor.submit(() -> increment(lockedCounter));
                jobs[index++] = executor.submit(() -> increment(atomicCounter));
            }
            for (Future<?> job : jobs) {
                job.get();
            }
        }

        int expected = WORKERS * INCREMENTS;
        System.out.println("Expected: " + expected);
        System.out.println("synchronized: " + synchronizedCounter.value());
        System.out.println("ReentrantLock: " + lockedCounter.value());
        System.out.println("AtomicInteger: " + atomicCounter.get());
    }

    private static void increment(SynchronizedCounter counter) {
        for (int i = 0; i < INCREMENTS; i++) counter.increment();
    }

    private static void increment(LockedCounter counter) {
        for (int i = 0; i < INCREMENTS; i++) counter.increment();
    }

    private static void increment(AtomicInteger counter) {
        for (int i = 0; i < INCREMENTS; i++) counter.incrementAndGet();
    }

    private static final class SynchronizedCounter {
        private int count;
        private synchronized void increment() { count++; }
        private synchronized int value() { return count; }
    }

    private static final class LockedCounter {
        private final ReentrantLock lock = new ReentrantLock();
        private int count;

        private void increment() {
            lock.lock();
            try {
                count++;
            } finally {
                lock.unlock();
            }
        }

        private int value() {
            lock.lock();
            try {
                return count;
            } finally {
                lock.unlock();
            }
        }
    }
}
