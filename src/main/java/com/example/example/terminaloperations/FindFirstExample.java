package com.example.terminaloperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Demonstrates terminal operation findFirst().
 * findFirst() ALWAYS respects encounter order.
 * Compatible with Java 8 through Java 21
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class FindFirstExample {

    public static void main(String[] args) {

        basicFindFirst();
        findFirstWithFilter();
        findFirstWithOrElse();
        findFirstEmptyStream();
        findFirstParallelStream();
    }

    // ---------------------------------------------------------
    // 1. BASIC findFirst() (Your original example)
    // ---------------------------------------------------------
    static void basicFindFirst() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        Optional<String> first =
                names.stream().findFirst();

        first.ifPresent(name ->
                System.out.println("1. Basic findFirst: " + name));
    }

    // ---------------------------------------------------------
    // 2. findFirst() AFTER filter()
    // ---------------------------------------------------------
    static void findFirstWithFilter() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        Optional<String> first =
                names.stream()
                        .filter(name -> name.length() > 3)
                        .findFirst();

        System.out.println("2. Filter + findFirst: " + first);
    }

    // ---------------------------------------------------------
    // 3. Using orElse() (Default value)
    // ---------------------------------------------------------
    static void findFirstWithOrElse() {

        List<String> names = Arrays.asList("Alice", "Bob");

        String result =
                names.stream()
                        .findFirst()
                        .orElse("No value");

        System.out.println("3. orElse(): " + result);
    }

    // ---------------------------------------------------------
    // 4. findFirst() on EMPTY stream
    // ---------------------------------------------------------
    static void findFirstEmptyStream() {

        List<String> empty = Arrays.asList();

        Optional<String> result =
                empty.stream().findFirst();

        System.out.println("4. Empty stream: " + result);
    }

    // ---------------------------------------------------------
    // 5. findFirst() with PARALLEL stream
    // ---------------------------------------------------------
    static void findFirstParallelStream() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Still returns FIRST element (order preserved)
        Optional<String> result =
                names.parallelStream().findFirst();

        System.out.println("5. Parallel stream findFirst: " + result);
    }
}