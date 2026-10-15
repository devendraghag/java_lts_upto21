package com.example.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/** Demonstrates virtual threads, finalized in JDK 21. */
public class VirtualThreadsDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread virtual = Thread.startVirtualThread(() ->
                System.out.println("Running on " + Thread.currentThread()));
        virtual.join();

        AtomicInteger completed = new AtomicInteger();
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 500; i++) {
                executor.execute(completed::incrementAndGet);
            }
        }
        System.out.println("Completed virtual-thread tasks: " + completed.get());
    }
}
