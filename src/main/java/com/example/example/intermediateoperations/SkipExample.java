package com.example.intermediateoperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates skip() intermediate operation.
 * skip(n) ignores first n elements.
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class SkipExample {

    public static void main(String[] args) {

        basicSkip();
        skipAfterFilter();
        skipWithLimit();
        skipEdgeCases();
    }

    // ---------------------------------------------------------
    // 1. BASIC skip() (Your original example)
    // ---------------------------------------------------------
    static void basicSkip() {

        List<String> names =
                Arrays.asList("Alice", "Bob", "Charlie", "David");

        names.stream()
                .skip(2)
                .forEach(System.out::println);
    }

    // ---------------------------------------------------------
    // 2. skip() AFTER filter()
    // ---------------------------------------------------------
    static void skipAfterFilter() {

        List<String> names =
                Arrays.asList("Alice", "Anna", "Bob", "Alex");

        names.stream()
                .filter(n -> n.startsWith("A"))
                .skip(1)
                .forEach(System.out::println);
    }

    // ---------------------------------------------------------
    // 3. skip() + limit() (Pagination style)
    // ---------------------------------------------------------
    static void skipWithLimit() {

        List<String> names =
                Arrays.asList("A", "B", "C", "D", "E");

        names.stream()
                .skip(1)
                .limit(2)
                .forEach(System.out::println);
    }

    // ---------------------------------------------------------
    // 4. Edge cases
    // ---------------------------------------------------------
    static void skipEdgeCases() {

        System.out.println(
                Arrays.asList("A", "B")
                        .stream()
                        .skip(10)
                        .toList()
        ); // []
    }
}