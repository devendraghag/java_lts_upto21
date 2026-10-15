package com.example.terminaloperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.stream.Stream;

/**
 * Demonstrates short-circuit behavior of terminal operations.
 * anyMatch stops processing once condition is satisfied.
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ShortCircuitTerminalExample {

    public static void main(String[] args) {

        anyMatchShortCircuit();
        findFirstShortCircuit();
        noneMatchShortCircuit();
    }

    // ---------------------------------------------------------
    // 1. anyMatch() short-circuiting (Your example)
    // ---------------------------------------------------------
    static void anyMatchShortCircuit() {

        boolean found =
                Stream.of(2, 4, 6, 7, 8)
                        .peek(n -> System.out.println("Checking: " + n))
                        .anyMatch(n -> n % 2 != 0);

        System.out.println("1. Odd number found: " + found);
    }

    // ---------------------------------------------------------
    // 2. findFirst() short-circuiting
    // ---------------------------------------------------------
    static void findFirstShortCircuit() {

        int firstOdd =
                Stream.of(2, 4, 6, 7, 8)
                        .peek(n -> System.out.println("Evaluating: " + n))
                        .filter(n -> n % 2 != 0)
                        .findFirst()
                        .orElse(-1);

        System.out.println("2. First odd: " + firstOdd);
    }

    // ---------------------------------------------------------
    // 3. noneMatch() short-circuiting
    // ---------------------------------------------------------
    static void noneMatchShortCircuit() {

        boolean noneNegative =
                Stream.of(1, 2, 3, -1, 4)
                        .peek(n -> System.out.println("Inspecting: " + n))
                        .noneMatch(n -> n < 0);

        System.out.println("3. No negative numbers: " + noneNegative);
    }
}