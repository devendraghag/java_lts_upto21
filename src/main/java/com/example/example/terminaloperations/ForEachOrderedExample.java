package com.example.terminaloperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.stream.Stream;

/**
 * Demonstrates difference between forEach() and forEachOrdered().
 * forEachOrdered() preserves encounter order even in parallel streams.
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ForEachOrderedExample {

    public static void main(String[] args) {

        forEachParallel();
        forEachOrderedParallel();
    }

    // ---------------------------------------------------------
    // 1. forEach() with parallel stream (order NOT preserved)
    // ---------------------------------------------------------
    static void forEachParallel() {

        System.out.print("forEach (parallel): ");

        Stream.of(1, 2, 3, 4, 5)
                .parallel()
                .forEach(n -> System.out.print(n + " "));

        System.out.println();
    }

    // ---------------------------------------------------------
    // 2. forEachOrdered() with parallel stream (order preserved)
    // ---------------------------------------------------------
    static void forEachOrderedParallel() {

        System.out.print("forEachOrdered (parallel): ");

        Stream.of(1, 2, 3, 4, 5)
                .parallel()
                .forEachOrdered(n -> System.out.print(n + " "));

        System.out.println("\nOrder preserved even in parallel stream");
    }
}
