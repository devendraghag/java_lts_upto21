package com.example.functionalinterfaces.functioninterfaces;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/** Pattern 18: use Functions with streams, Optional.map, and thenApply. */
public class FunctionPattern18_StreamOptionalAndAsync {
    public static void main(String[] args) {
        Function<String, String> uppercase = String::toUpperCase;
        List<String> results = List.of("java", "sql").stream().map(uppercase).toList();
        String optionalResult = Optional.of("spring").map(uppercase).orElse("none");
        String asyncResult = CompletableFuture.completedFuture("jdk")
                .thenApply(uppercase)
                .join();

        System.out.println("Stream: " + results);
        System.out.println("Optional: " + optionalResult);
        System.out.println("CompletableFuture: " + asyncResult);
    }
}