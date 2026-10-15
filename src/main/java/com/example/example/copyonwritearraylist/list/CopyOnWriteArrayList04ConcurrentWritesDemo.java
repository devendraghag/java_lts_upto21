package com.example.copyonwritearraylist.list;

import java.util.concurrent.CopyOnWriteArrayList;

/** Demonstrates that multiple threads can safely add to a CopyOnWriteArrayList. */
public class CopyOnWriteArrayList04ConcurrentWritesDemo {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<Integer> values = new CopyOnWriteArrayList<>();

        // Each thread performs independent writes to the same thread-safe list.
        Thread firstWriter = new Thread(() -> addRange(values, 0, 100), "first-writer");
        Thread secondWriter = new Thread(() -> addRange(values, 100, 200), "second-writer");

        firstWriter.start();
        secondWriter.start();

        // Wait for both writers so the final size can be observed.
        firstWriter.join();
        secondWriter.join();

        System.out.println("Number of values added: " + values.size());
        System.out.println("First value present: " + values.contains(0));
        System.out.println("Last value present: " + values.contains(199));
    }

    private static void addRange(CopyOnWriteArrayList<Integer> values, int start, int end) {
        for (int value = start; value < end; value++) {
            values.add(value);
        }
    }
}
