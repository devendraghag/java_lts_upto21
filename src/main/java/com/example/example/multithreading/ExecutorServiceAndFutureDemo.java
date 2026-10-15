package com.example.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/** Submits result-producing tasks to a fixed thread pool. */
public class ExecutorServiceAndFutureDemo {
    public static void main(String[] args) throws Exception {
        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {
            Callable<Integer> first = () -> calculateSquare(12);
            Future<Integer> firstResult = executor.submit(first);
            Future<Integer> secondResult = executor.submit(() -> calculateSquare(15));

            System.out.println("First result: " + firstResult.get());
            System.out.println("Second result: " + secondResult.get());
        } // Closing the executor waits for submitted tasks and releases its workers.
    }

    private static int calculateSquare(int value) {
        return value * value;
    }
}
