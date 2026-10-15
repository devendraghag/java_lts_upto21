package com.example.terminaloperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Arrays;

/**
 * Demonstrates reduce() with identity value.
 * Identity acts as default result AND starting point.
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ReduceWithIdentityExample {

    public static void main(String[] args) {

        correctIdentity();
        dangerousIdentity();
    }

    // ---------------------------------------------------------
    // 1. CORRECT identity usage (Your example)
    // ---------------------------------------------------------
    static void correctIdentity() {

        int sum =
                Arrays.asList(1, 2, 3, 4)
                        .stream()
                        .reduce(10, Integer::sum);

        System.out.println("1. Sum with identity 10: " + sum);
    }

    // ---------------------------------------------------------
    // 2. ⚠️ DANGEROUS identity in parallel streams
    // ---------------------------------------------------------
    static void dangerousIdentity() {

        int sum =
                Arrays.asList(1, 2, 3, 4)
                        .parallelStream()
                        .reduce(10, Integer::sum);

        // Identity may be applied MULTIPLE times
        System.out.println("2. Parallel sum with identity 10: " + sum);
    }
}