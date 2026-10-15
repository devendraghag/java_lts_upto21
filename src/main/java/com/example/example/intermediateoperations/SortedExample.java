package com.example.intermediateoperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates sorted() natural ordering.
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class SortedExample {

    public static void main(String[] args) {

        basicSorted();
        sortedAfterMap();
        sortedParallelStream();
    }

    // ---------------------------------------------------------
    // 1. BASIC sorted() (Your original example)
    // ---------------------------------------------------------
    static void basicSorted() {

        List<String> names =
                Arrays.asList("Charlie", "Alice", "Bob");

        names.stream()
                .sorted()
                .forEach(System.out::println);
    }

    // ---------------------------------------------------------
    // 2. sorted() AFTER map()
    // ---------------------------------------------------------
    static void sortedAfterMap() {

        List<String> names =
                Arrays.asList("charlie", "alice", "bob");

        names.stream()
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }

    // ---------------------------------------------------------
    // 3. sorted() with parallel stream (ORDER preserved)
    // ---------------------------------------------------------
    static void sortedParallelStream() {

        List<String> names =
                Arrays.asList("Charlie", "Alice", "Bob");

        names.parallelStream()
                .sorted()
                .forEach(System.out::println);
    }
}