package com.example.terminaloperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Demonstrates terminal operation min().
 * min() returns the minimum element according to a Comparator.
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class MinExample {

    public static void main(String[] args) {

        basicMin();
        minWithCustomComparator();
        minAfterFilter();
        minEmptyStream();
        minParallelStream();
    }

    // ---------------------------------------------------------
    // 1. BASIC min() (Your original example)
    // ---------------------------------------------------------
    static void basicMin() {

        List<String> names = Arrays.asList("Charlie", "Bob", "Alice");

        Optional<String> min =
                names.stream().min(Comparator.naturalOrder());

        min.ifPresent(name ->
                System.out.println("1. Basic min: " + name)); // Alice
    }

    // ---------------------------------------------------------
    // 2. min() with CUSTOM comparator
    // ---------------------------------------------------------
    static void minWithCustomComparator() {

        List<String> names = Arrays.asList("Charlie", "Bob", "Alice");

        // Finds shortest string
        Optional<String> min =
                names.stream()
                        .min(Comparator.comparingInt(String::length));

        System.out.println("2. Shortest name: " + min);
    }

    // ---------------------------------------------------------
    // 3. min() AFTER filter()
    // ---------------------------------------------------------
    static void minAfterFilter() {

        List<String> names = Arrays.asList("Charlie", "Bob", "Alice");

        Optional<String> min =
                names.stream()
                        .filter(name -> name.length() > 3)
                        .min(Comparator.naturalOrder());

        System.out.println("3. Filter + min: " + min);
    }

    // ---------------------------------------------------------
    // 4. min() on EMPTY stream
    // ---------------------------------------------------------
    static void minEmptyStream() {

        List<String> empty = Arrays.asList();

        Optional<String> min =
                empty.stream().min(Comparator.naturalOrder());

        System.out.println("4. Empty stream min: " + min);
    }

    // ---------------------------------------------------------
    // 5. min() with PARALLEL stream
    // ---------------------------------------------------------
    static void minParallelStream() {

        List<String> names = Arrays.asList("Charlie", "Bob", "Alice");

        Optional<String> min =
                names.parallelStream().min(Comparator.naturalOrder());

        System.out.println("5. Parallel stream min: " + min);
    }
}
