package com.example.intermediateoperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates limit() intermediate operation.
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class LimitExample {

    public static void main(String[] args) {

        basicLimit();
        limitAfterFilter();
        limitWithInfiniteStream();
    }

    // ---------------------------------------------------------
    // 1. BASIC limit() (Your original example)
    // ---------------------------------------------------------
    static void basicLimit() {

        List<String> names =
                Arrays.asList("Alice", "Bob", "Charlie", "David");

        names.stream()
                .limit(2)
                .forEach(System.out::println);
    }

    // ---------------------------------------------------------
    // 2. limit() AFTER filter()
    // ---------------------------------------------------------
    static void limitAfterFilter() {

        List<String> names =
                Arrays.asList("Alice", "Bob", "Anna", "Alex");

        names.stream()
                .filter(n -> n.startsWith("A"))
                .limit(1)
                .forEach(System.out::println);
    }

    // ---------------------------------------------------------
    // 3. limit() with infinite stream
    // ---------------------------------------------------------
    static void limitWithInfiniteStream() {

        java.util.stream.Stream.iterate(1, n -> n + 1)
                .limit(5)
                .forEach(System.out::println);
    }
}