package com.example.example.exceptionhandling;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/** HARD 22: handle failures at the thread and CompletableFuture boundaries. */
public class ExceptionHandling22ThreadAndCompletableFuture {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            throw new IllegalStateException("Thread task failed");
        }, "worker");

        // A try/catch around start() on the main thread does not catch worker failures.
        worker.setUncaughtExceptionHandler((thread, failure) ->
                System.out.println(thread.getName() + " failed: " + failure.getMessage()));
        worker.start();
        worker.join();

        try {
            CompletableFuture.supplyAsync(() -> {
                throw new IllegalArgumentException("Async task failed");
            }).join();
        } catch (CompletionException exception) {
            System.out.println("Future failed: " + exception.getCause());
        }
    }
}
