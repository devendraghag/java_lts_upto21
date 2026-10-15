package com.example.completablefuture;

import java.util.concurrent.CompletableFuture;

/** Chain a second asynchronous task that depends on the first task's result. */
public class CompletableFuture05ThenComposeDemo {
    public static void main(String[] args) {
        CompletableFuture<String> profile = findUserIdAsync()
                // The user ID is needed before the profile lookup can begin.
                .thenCompose(CompletableFuture05ThenComposeDemo::loadProfileAsync);

        System.out.println(profile.join());
    }

    private static CompletableFuture<Integer> findUserIdAsync() {
        return CompletableFuture.supplyAsync(() -> 42);
    }

    private static CompletableFuture<String> loadProfileAsync(int userId) {
        return CompletableFuture.supplyAsync(() -> "Profile for user " + userId);
    }
}
