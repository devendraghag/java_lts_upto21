package com.example.intermediateoperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates flatMap() intermediate operation.
 * Used to flatten nested structures.
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class FlatMapExample {

    public static void main(String[] args) {

        basicFlatMap();
        flatMapWithFilter();
        flatMapVsMap();
    }

    // ---------------------------------------------------------
    // 1. BASIC flatMap() (Your original example)
    // ---------------------------------------------------------
    static void basicFlatMap() {

        List<List<String>> namesList =
                Arrays.asList(
                        Arrays.asList("Alice", "Bob"),
                        Arrays.asList("Charlie", "David")
                );

        namesList.stream()
                .flatMap(List::stream)
                .forEach(System.out::println);
    }

    // ---------------------------------------------------------
    // 2. flatMap() + filter()
    // ---------------------------------------------------------
    static void flatMapWithFilter() {

        List<List<String>> namesList =
                Arrays.asList(
                        Arrays.asList("Alice", "Bob"),
                        Arrays.asList("Charlie", "David")
                );

        namesList.stream()
                .flatMap(List::stream)
                .filter(name -> name.length() > 4)
                .forEach(System.out::println);
    }

    // ---------------------------------------------------------
    // 3. flatMap() vs map()
    // ---------------------------------------------------------
    static void flatMapVsMap() {

        List<List<String>> namesList =
                Arrays.asList(
                        Arrays.asList("A", "B"),
                        Arrays.asList("C", "D")
                );

        System.out.println("map():");
        namesList.stream().map(List::stream).forEach(System.out::println);

        System.out.println("flatMap():");
        namesList.stream().flatMap(List::stream).forEach(System.out::println);
    }
}