package com.example.intermediateoperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates distinct() intermediate operation.
 * distinct() uses equals() and hashCode() internally.
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class DistinctExample {

    public static void main(String[] args) {

        basicDistinct();
        distinctAfterMap();
        distinctWithParallelStream();
        distinctVsSet();
    }

    // ---------------------------------------------------------
    // 1. BASIC distinct() (Your original example)
    // ---------------------------------------------------------
    static void basicDistinct() {

        List<String> names = Arrays.asList("Alice", "Bob", "Alice", "Charlie");

        names.stream()
                .distinct()
                .forEach(System.out::println);
    }

    // ---------------------------------------------------------
    // 2. distinct() AFTER map()
    // ---------------------------------------------------------
    static void distinctAfterMap() {

        List<String> names = Arrays.asList("alice", "Alice", "ALICE");

        names.stream()
                .map(String::toLowerCase)
                .distinct()
                .forEach(System.out::println);
    }

    // ---------------------------------------------------------
    // 3. distinct() with parallel stream
    // ---------------------------------------------------------
    static void distinctWithParallelStream() {

        List<String> names = Arrays.asList("A", "B", "A", "C");

        names.parallelStream()
                .distinct()
                .forEach(System.out::print);

        System.out.println("\nOrder not guaranteed in parallel");
    }

    // ---------------------------------------------------------
    // 4. distinct() vs Set
    // ---------------------------------------------------------
    static void distinctVsSet() {

        List<String> names = Arrays.asList("A", "B", "A", "C");

        System.out.println("Using distinct:");
        names.stream().distinct().forEach(System.out::print);

        System.out.println("\nUsing Set:");
        System.out.println(new java.util.HashSet<>(names));
    }
}