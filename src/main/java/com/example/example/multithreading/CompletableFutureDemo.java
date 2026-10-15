package com.example.multithreading;

import java.util.concurrent.CompletableFuture;

/** Demonstrates composing asynchronous tasks with CompletableFuture. */
public class CompletableFutureDemo {
    public static void main(String[] args) {
        CompletableFuture<Integer> price = CompletableFuture.supplyAsync(() -> 80);
        CompletableFuture<Integer> shipping = CompletableFuture.supplyAsync(() -> 10);

        CompletableFuture<String> receipt = price
                .thenCombine(shipping, Integer::sum)
                .thenApply(total -> "Order total: " + total);
        System.out.println(receipt.join());

        CompletableFuture<String> recovered = CompletableFuture
                .<String>supplyAsync(() -> {
                    throw new IllegalStateException("sample failure");
                })
                .exceptionally(error -> "Recovered after "
                        + error.getCause().getClass().getSimpleName());
        System.out.println(recovered.join());
    }
}
