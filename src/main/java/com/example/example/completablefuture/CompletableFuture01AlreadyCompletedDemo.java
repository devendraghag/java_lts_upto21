package com.example.completablefuture;

import java.util.concurrent.CompletableFuture;

/** Easiest: create a future that already has its result. */
public class CompletableFuture01AlreadyCompletedDemo {
    public static void main(String[] args) {
        // completedFuture is useful when a method must return a future,
        // but the answer is already available.
        CompletableFuture<String> result = CompletableFuture.completedFuture("Ready");

        // join returns immediately here because the future is already complete.
        System.out.println(result.join());
    }
}
