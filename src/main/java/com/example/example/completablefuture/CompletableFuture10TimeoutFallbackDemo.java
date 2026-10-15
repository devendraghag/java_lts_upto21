package com.example.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/** Complete with a fallback value if the task takes longer than the timeout. */
public class CompletableFuture10TimeoutFallbackDemo {
    public static void main(String[] args) {
        CompletableFuture<String> result = CompletableFuture
                .supplyAsync(() -> slowLookup())
                // If the lookup is still incomplete after 100 ms, use this value.
                .completeOnTimeout("Fallback answer", 100, TimeUnit.MILLISECONDS);

        System.out.println(result.join());
    }

    private static String slowLookup() {
        try {
            Thread.sleep(500);
            return "Answer from slow lookup";
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Lookup was interrupted", exception);
        }
    }
}
