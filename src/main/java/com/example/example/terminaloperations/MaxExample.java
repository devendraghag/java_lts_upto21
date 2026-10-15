package com.example.terminaloperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Demonstrates terminal operation max().
 * max() returns the maximum element according to a Comparator.
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class MaxExample {

    public static void main(String[] args) {

        basicMax();
        maxWithCustomComparator();
        maxAfterFilter();
        maxEmptyStream();
        maxParallelStream();
    }

    // ---------------------------------------------------------
    // 1. BASIC max() (Your original example)
    // ---------------------------------------------------------
    static void basicMax() {

        List<String> names = Arrays.asList("Charlie", "Bob", "Alice");

        Optional<String> max =
                names.stream().max(Comparator.naturalOrder());

        max.ifPresent(name ->
                System.out.println("1. Basic max: " + name)); // Charlie
    }

    // ---------------------------------------------------------
    // 2. max() with CUSTOM comparator
    // ---------------------------------------------------------
    static void maxWithCustomComparator() {

        List<String> names = Arrays.asList("Charlie", "Bob", "Alice");

        // Finds longest string
        Optional<String> max =
                names.stream()
                        .max(Comparator.comparingInt(String::length));

        System.out.println("2. Longest name: " + max);
    }

    // ---------------------------------------------------------
    // 3. max() AFTER filter()
    // ---------------------------------------------------------
    static void maxAfterFilter() {

        List<String> names = Arrays.asList("Charlie", "Bob", "Alice");

        Optional<String> max =
                names.stream()
                        .filter(name -> name.length() > 3)
                        .max(Comparator.naturalOrder());

        System.out.println("3. Filter + max: " + max);
    }

    // ---------------------------------------------------------
    // 4. max() on EMPTY stream
    // ---------------------------------------------------------
    static void maxEmptyStream() {

        List<String> empty = Arrays.asList();

        Optional<String> max =
                empty.stream().max(Comparator.naturalOrder());

        System.out.println("4. Empty stream max: " + max);
    }

    // ---------------------------------------------------------
    // 5. max() with PARALLEL stream
    // ---------------------------------------------------------
    static void maxParallelStream() {

        List<String> names = Arrays.asList("Charlie", "Bob", "Alice");

        Optional<String> max =
                names.parallelStream().max(Comparator.naturalOrder());

        System.out.println("5. Parallel stream max: " + max);
    }
}
