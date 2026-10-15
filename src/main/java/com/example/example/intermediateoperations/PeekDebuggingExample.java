package com.example.intermediateoperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.stream.IntStream;

/**
 * Demonstrates correct usage of peek().
 * peek() is meant ONLY for debugging/logging.
 * It should NOT change stream elements.
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class PeekDebuggingExample {

    public static void main(String[] args) {

        basicPeekDebugging();
        peekWithFilter();
        peekParallelWarning();
    }

    // ---------------------------------------------------------
    // 1. BASIC peek() for debugging (Your original example)
    // ---------------------------------------------------------
    static void basicPeekDebugging() {

        int sum =
                IntStream.rangeClosed(1, 5)
                        .peek(n -> System.out.println("Before map: " + n))
                        .map(n -> n * 2)
                        .peek(n -> System.out.println("After map: " + n))
                        .sum();

        System.out.println("Sum: " + sum);
    }

    // ---------------------------------------------------------
    // 2. peek() AFTER filter()
    // ---------------------------------------------------------
    static void peekWithFilter() {

        IntStream.rangeClosed(1, 5)
                .filter(n -> n % 2 == 0)
                .peek(n -> System.out.println("Even number: " + n))
                .forEach(n -> {});
    }

    // ---------------------------------------------------------
    // 3. ⚠️ peek() with parallel stream (order not guaranteed)
    // ---------------------------------------------------------
    static void peekParallelWarning() {

        IntStream.rangeClosed(1, 5)
                .parallel()
                .peek(n -> System.out.println("Parallel peek: " + n))
                .forEach(n -> {});
    }
}