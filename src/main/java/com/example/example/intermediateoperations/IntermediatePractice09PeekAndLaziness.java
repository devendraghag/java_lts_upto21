package com.example.intermediateoperations;

import java.util.List;

/** Medium: peek actions are observed as elements flow after a terminal operation starts. */
public class IntermediatePractice09PeekAndLaziness {
    public static void main(String[] args) {
        var pipeline = List.of(2, 4, 6).stream()
                .peek(value -> System.out.println("Before map: " + value))
                .map(value -> value * 10)
                .peek(value -> System.out.println("After map: " + value));
        System.out.println("Pipeline created; peek has not run.");
        System.out.println("Result: " + pipeline.toList());
    }
}