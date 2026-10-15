package com.example.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** Run asynchronous work using an executor chosen by the application. */
public class CompletableFuture09CustomExecutorDemo {
    public static void main(String[] args) {
        // A fixed pool lets this program choose how many worker threads to use.
        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {
            CompletableFuture<String> task = CompletableFuture.supplyAsync(
                    () -> "Work ran on " + Thread.currentThread().getName(), executor);

            System.out.println(task.join());
        }
    }
}
