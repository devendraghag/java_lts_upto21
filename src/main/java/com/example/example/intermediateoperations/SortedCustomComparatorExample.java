package com.example.intermediateoperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Comparator;
import java.util.List;

/**
 * Demonstrates sorted() with custom comparator.
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class SortedCustomComparatorExample {

    public static void main(String[] args) {

        sortByLength();
        sortByLengthDesc();
        sortWithThenComparing();
    }

    // ---------------------------------------------------------
    // 1. Sort by length (Your original example)
    // ---------------------------------------------------------
    static void sortByLength() {

        List<String> names = java.util.Arrays.asList("Java", "Spring", "API", "Stream");

        names.stream()
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);
    }

    // ---------------------------------------------------------
    // 2. Sort by length DESC
    // ---------------------------------------------------------
    static void sortByLengthDesc() {

        List<String> names = java.util.Arrays.asList("Java", "Spring", "API", "Stream");

        names.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .forEach(System.out::println);
    }

    // ---------------------------------------------------------
    // 3. thenComparing()
    // ---------------------------------------------------------
    static void sortWithThenComparing() {

        List<String> names = java.util.Arrays.asList("AA", "B", "CC", "A");

        names.stream()
                .sorted(Comparator
                        .comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);
    }
}