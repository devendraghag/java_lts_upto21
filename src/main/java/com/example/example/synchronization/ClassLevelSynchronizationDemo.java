package com.example.synchronization;

/** Demonstrates class-level locking with a static synchronized method. */
public class ClassLevelSynchronizationDemo {
    private static final class SharedSequence {
        private static int nextValue;

        private static synchronized int next() {
            return ++nextValue; // Locks SharedSequence.class.
        }
    }

    public static void main(String[] args) {
        System.out.println(SharedSequence.next());
        System.out.println(SharedSequence.next());
    }
}
