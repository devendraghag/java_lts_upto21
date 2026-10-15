package com.example.terminaloperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.stream.IntStream;

/**
 * Demonstrates performance vs determinism tradeoff in parallel streams.
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ParallelDeterminismTradeoffExample {

    public static void main(String[] args) {

        forEachParallel();
        forEachOrderedParallel();
        explanation();
    }

    // ---------------------------------------------------------
    // 1. forEach() with parallel stream (FAST, non-deterministic)
    // ---------------------------------------------------------
    static void forEachParallel() {

        System.out.print("forEach (parallel): ");

        IntStream.rangeClosed(1, 10)
                .parallel()
                .forEach(n -> System.out.print(n + " "));

        System.out.println("\nOrder NOT guaranteed\n");
    }

    // ---------------------------------------------------------
    // 2. forEachOrdered() with parallel stream (ORDERED, slower)
    // ---------------------------------------------------------
    static void forEachOrderedParallel() {

        System.out.print("forEachOrdered (parallel): ");

        IntStream.rangeClosed(1, 10)
                .parallel()
                .forEachOrdered(n -> System.out.print(n + " "));

        System.out.println("\nOrder guaranteed\n");
    }

    // ---------------------------------------------------------
    // 3. Key explanation
    // ---------------------------------------------------------
    static void explanation() {

        System.out.println("""
                Explanation:
                - Parallel streams split work across threads
                - forEach() allows threads to print independently (faster)
                - forEachOrdered() synchronizes order (slower)
                - Choose based on correctness vs performance
                """);
    }
}
