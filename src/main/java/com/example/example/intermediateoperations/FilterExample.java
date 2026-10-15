package com.example.intermediateoperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates filter() intermediate operation.
 * filter() evaluates ALL elements.
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class FilterExample {

    public static void main(String[] args) {

        basicFilter();
        filterWithMultipleConditions();
        filterAfterMap();
        filterParallelStream();
    }

    // ---------------------------------------------------------
    // 1. BASIC filter() (Your original example)
    // ---------------------------------------------------------
    static void basicFilter() {

        List<String> names = Arrays.asList("Alice", "Bob", "Anna", "Charlie");

        names.stream()
                .filter(name -> name.startsWith("A"))
                .forEach(System.out::println);
    }

    // ---------------------------------------------------------
    // 2. filter() with multiple conditions
    // ---------------------------------------------------------
    static void filterWithMultipleConditions() {

        List<String> names = Arrays.asList("Alice", "Anna", "Bob");

        names.stream()
                .filter(n -> n.startsWith("A") && n.length() > 4)
                .forEach(System.out::println);
    }

    // ---------------------------------------------------------
    // 3. filter() AFTER map()
    // ---------------------------------------------------------
    static void filterAfterMap() {

        List<String> names = Arrays.asList("alice", "bob", "anna");

        names.stream()
                .map(String::toUpperCase)
                .filter(n -> n.startsWith("A"))
                .forEach(System.out::println);
    }

    // ---------------------------------------------------------
    // 4. filter() with parallel stream
    // ---------------------------------------------------------
    static void filterParallelStream() {

        List<String> names = Arrays.asList("Alice", "Bob", "Anna", "Charlie");

        names.parallelStream()
                .filter(n -> n.contains("a") || n.contains("A"))
                .forEach(System.out::println);
    }
}