package com.example.completablefuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/** Wait for several independent tasks, then collect all their results. */
public class CompletableFuture08AllOfDemo {
    public static void main(String[] args) {
        List<CompletableFuture<String>> tasks = List.of(
                CompletableFuture.supplyAsync(() -> "Profile loaded"),
                CompletableFuture.supplyAsync(() -> "Orders loaded"),
                CompletableFuture.supplyAsync(() -> "Settings loaded")
        );

        CompletableFuture<?>[] taskArray = tasks.toArray(CompletableFuture<?>[]::new);

        // allOf completes after every task completes. It does not collect values,
        // so join each task after the allOf stage has finished.
        CompletableFuture<List<String>> allResults = CompletableFuture.allOf(taskArray)
                .thenApply(ignored -> tasks.stream()
                        .map(CompletableFuture::join)
                        .toList());

        System.out.println(allResults.join());
    }
}
