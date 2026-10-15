package com.example.intermediateoperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates map() intermediate operation.
 * map() transforms elements one-to-one.
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class MapExample {

    public static void main(String[] args) {

        basicMap();
        mapToLength();
        mapAfterFilter();
        mapParallelStream();
    }

    // ---------------------------------------------------------
    // 1. BASIC map() (Your original example)
    // ---------------------------------------------------------
    static void basicMap() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    // ---------------------------------------------------------
    // 2. map() to different type
    // ---------------------------------------------------------
    static void mapToLength() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        names.stream()
                .map(String::length)
                .forEach(System.out::println);
    }

    // ---------------------------------------------------------
    // 3. map() AFTER filter()
    // ---------------------------------------------------------
    static void mapAfterFilter() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        names.stream()
                .filter(n -> n.length() > 3)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    // ---------------------------------------------------------
    // 4. map() with parallel stream
    // ---------------------------------------------------------
    static void mapParallelStream() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        names.parallelStream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}