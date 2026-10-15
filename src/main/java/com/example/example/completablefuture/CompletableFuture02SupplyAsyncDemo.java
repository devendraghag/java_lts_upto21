package com.example.completablefuture;

import java.util.concurrent.CompletableFuture;

/** Start an asynchronous task that produces a result. */
public class CompletableFuture02SupplyAsyncDemo {
    public static void main(String[] args) {
        // supplyAsync runs a value-producing task asynchronously.
        CompletableFuture<String> task = CompletableFuture.supplyAsync(() -> "Data loaded");

        // join waits here only when the result is needed.
        System.out.println(task.join());
    }
}
