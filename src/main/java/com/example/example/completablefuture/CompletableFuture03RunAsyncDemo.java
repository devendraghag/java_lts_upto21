package com.example.completablefuture;

import java.util.concurrent.CompletableFuture;

/** Run an asynchronous task that does work but returns no result. */
public class CompletableFuture03RunAsyncDemo {
    public static void main(String[] args) {
        // runAsync takes a Runnable, so it represents work with no result value.
        CompletableFuture<Void> task = CompletableFuture.runAsync(
                () -> System.out.println("Saving report"));

        // join waits until the action finishes.
        task.join();
        System.out.println("Save finished");
    }
}
