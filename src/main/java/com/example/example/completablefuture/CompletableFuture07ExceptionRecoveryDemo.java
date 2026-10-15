package com.example.completablefuture;

import java.util.concurrent.CompletableFuture;

/** Recover from an asynchronous failure with a fallback value. */
public class CompletableFuture07ExceptionRecoveryDemo {
    public static void main(String[] args) {
        CompletableFuture<String> result = CompletableFuture
                .<String>supplyAsync(() -> {
                    throw new IllegalStateException("Service is unavailable");
                })
                // exceptionally runs only when the earlier stage fails.
                .exceptionally(error -> "Fallback result (" + error.getClass().getSimpleName() + ")");

        System.out.println(result.join());
    }
}
