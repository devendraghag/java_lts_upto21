package com.example.terminaloperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Demonstrates terminal operation findAny().
 * findAny() returns ANY element from the stream wrapped in Optional.
 * It is short-circuiting and especially useful with parallel streams.
 *
 * Compatible with Java 8 through Java 21
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class FindAnyExample {

    public static void main(String[] args) {

        basicFindAny();
        findAnyWithFilter();
        findAnyWithIfPresent();
        findAnyWithOrElse();
        findAnyWithOrElseThrow();
        findAnyEmptyStream();
        findAnyParallelStream();
        findAnyVsFindFirst();
    }

    // ---------------------------------------------------------
    // 1. BASIC findAny() (Your original example)
    // ---------------------------------------------------------
    static void basicFindAny() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // findAny() returns Optional<T>
        Optional<String> any =
                names.stream().findAny();

        System.out.println("1. Basic findAny: " + any);
    }

    // ---------------------------------------------------------
    // 2. findAny() AFTER filter()
    // ---------------------------------------------------------
    static void findAnyWithFilter() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Finds ANY name that starts with 'C'
        Optional<String> result =
                names.stream()
                        .filter(name -> name.startsWith("C"))
                        .findAny();

        System.out.println("2. Filter + findAny: " + result);
    }

    // ---------------------------------------------------------
    // 3. Using ifPresent() (Safe Optional handling)
    // ---------------------------------------------------------
    static void findAnyWithIfPresent() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        names.stream()
                .findAny()
                .ifPresent(name ->
                        System.out.println("3. ifPresent(): " + name)
                );
    }

    // ---------------------------------------------------------
    // 4. Using orElse() (Default value)
    // ---------------------------------------------------------
    static void findAnyWithOrElse() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        String result =
                names.stream()
                        .findAny()
                        .orElse("No value found");

        System.out.println("4. orElse(): " + result);
    }

    // ---------------------------------------------------------
    // 5. Using orElseThrow() (Fail fast)
    // ---------------------------------------------------------
    static void findAnyWithOrElseThrow() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        String result =
                names.stream()
                        .findAny()
                        .orElseThrow(() ->
                                new RuntimeException("Stream was empty"));

        System.out.println("5. orElseThrow(): " + result);
    }

    // ---------------------------------------------------------
    // 6. findAny() on EMPTY stream (Important interview point)
    // ---------------------------------------------------------
    static void findAnyEmptyStream() {

        List<String> empty = Arrays.asList();

        Optional<String> result =
                empty.stream().findAny();

        System.out.println("6. Empty stream findAny: " + result);
        // Output: Optional.empty
    }

    // ---------------------------------------------------------
    // 7. findAny() with PARALLEL stream (Key difference)
    // ---------------------------------------------------------
    static void findAnyParallelStream() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // In parallel streams, ANY element may be returned
        Optional<String> result =
                names.parallelStream().findAny();

        System.out.println("7. Parallel stream findAny: " + result);
    }

    // ---------------------------------------------------------
    // 8. findAny() vs findFirst() (VERY IMPORTANT)
    // ---------------------------------------------------------
    static void findAnyVsFindFirst() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        Optional<String> any =
                names.stream().findAny();

        Optional<String> first =
                names.stream().findFirst();

        System.out.println("8. findAny():   " + any);
        System.out.println("   findFirst(): " + first);
    }
}
