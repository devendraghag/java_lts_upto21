package com.example.completablefuture;

import java.util.concurrent.CompletableFuture;

/** Transform a result, then consume it with a side effect. */
public class CompletableFuture04ThenApplyAndAcceptDemo {
    public static void main(String[] args) {
        CompletableFuture<Void> task = CompletableFuture
                .supplyAsync(() -> "java")
                // thenApply transforms one result into another result.
                .thenApply(String::toUpperCase)
                // thenAccept uses the result and returns no new value.
                .thenAccept(word -> System.out.println("Language: " + word));

        task.join();
    }
}
