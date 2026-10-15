package com.example.interfaces;

/** Demonstrates a sealed interface and its permitted implementations (Java 17+). */
public class SealedInterfaceDemo {
    private sealed interface Result permits Success, Failure {
        String message();
    }

    private record Success(String message) implements Result {
    }

    private record Failure(String message) implements Result {
    }

    public static void main(String[] args) {
        Result result = new Success("Operation completed");
        System.out.println(result.message());
    }
}
