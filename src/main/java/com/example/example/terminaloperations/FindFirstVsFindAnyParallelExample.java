package com.example.terminaloperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.stream.Stream;

/**
 * Demonstrates difference between findFirst() and findAny()
 * when used with parallel streams.
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class FindFirstVsFindAnyParallelExample {

    public static void main(String[] args) {

        findAnyParallel();
        findFirstParallel();
        explanation();
    }

    // ---------------------------------------------------------
    // 1. findAny() in parallel stream
    // ---------------------------------------------------------
    static void findAnyParallel() {

        // May return ANY element (non-deterministic)
        Integer result =
                Stream.of(1, 2, 3, 4, 5)
                        .parallel()
                        .findAny()
                        .get();

        System.out.println("findAny (parallel): " + result);
    }

    // ---------------------------------------------------------
    // 2. findFirst() in parallel stream
    // ---------------------------------------------------------
    static void findFirstParallel() {

        // ALWAYS returns first element (order preserved)
        Integer result =
                Stream.of(1, 2, 3, 4, 5)
                        .parallel()
                        .findFirst()
                        .get();

        System.out.println("findFirst (parallel): " + result);
    }

    // ---------------------------------------------------------
    // 3. Key explanation
    // ---------------------------------------------------------
    static void explanation() {

        System.out.println("""
                Explanation:
                - findAny(): Faster, may return any element
                - findFirst(): Slower, preserves encounter order
                - In parallel streams, prefer findAny() if order is not required
                """);
    }
}
