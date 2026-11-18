package com.example.example.exceptionhandling;

import java.util.concurrent.CompletableFuture;

/** HARD 30: recover from asynchronous failure with exceptionally and handle. */
public class ExceptionHandling30CompletableFutureRecovery {
    public static void main(String[] args) {
        String fallback = CompletableFuture.<String>supplyAsync(() -> {
                    throw new IllegalStateException("Primary service unavailable");
                })
                .exceptionally(failure -> {
                    System.out.println("exceptionally saw: " + rootCause(failure));
                    return "fallback value";
                })
                .join();
        System.out.println("Recovered value: " + fallback);

        String handled = CompletableFuture.<String>supplyAsync(() -> {
                    throw new IllegalArgumentException("Invalid async request");
                })
                .handle((value, failure) -> failure == null
                        ? "Success: " + value
                        : "Recovered by handle: " + rootCause(failure).getMessage())
                .join();
        System.out.println(handled);
    }

    private static Throwable rootCause(Throwable failure) {
        return failure.getCause() == null ? failure : failure.getCause();
    }
}
