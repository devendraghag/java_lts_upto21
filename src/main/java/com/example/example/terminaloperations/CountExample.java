package com.example.terminaloperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Demonstrates terminal operation count()
 * Shows common, filtered, mapped, and alternative counting approaches
 * Compatible with Java 8 through Java 21
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class CountExample {

    public static void main(String[] args) {

        basicCount();
        countAfterFilter();
        countAfterMap();
        countWithDistinct();
        countUsingIntStream();
        countUsingCollecting();
        countEmptyStream();
        countParallelStream();
    }

    // ---------------------------------------------------------
    // 1. BASIC count() – Your original example
    // ---------------------------------------------------------
    static void basicCount() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // count() returns number of elements in the stream
        long count = names.stream().count();

        System.out.println("1. Basic count: " + count);
    }

    // ---------------------------------------------------------
    // 2. count() AFTER filter() (Conditional counting)
    // ---------------------------------------------------------
    static void countAfterFilter() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Ann");

        // Count only names with length > 3
        long count =
                names.stream()
                        .filter(name -> name.length() > 3)
                        .count();

        System.out.println("2. Filter + count: " + count);
    }

    // ---------------------------------------------------------
    // 3. count() AFTER map() (Transform then count)
    // ---------------------------------------------------------
    static void countAfterMap() {

        List<String> names = Arrays.asList("java", "streams", "api");

        // map() transforms elements, count() still counts elements
        long count =
                names.stream()
                        .map(String::toUpperCase)
                        .count();

        System.out.println("3. Map + count: " + count);
    }

    // ---------------------------------------------------------
    // 4. count() with distinct() (Unique elements)
    // ---------------------------------------------------------
    static void countWithDistinct() {

        List<String> names = Arrays.asList("Alice", "Bob", "Alice", "Bob", "Charlie");

        // distinct() removes duplicates before counting
        long count =
                names.stream()
                        .distinct()
                        .count();

        System.out.println("4. Distinct + count: " + count);
    }

    // ---------------------------------------------------------
    // 5. Using IntStream (Performance-oriented)
    // ---------------------------------------------------------
    static void countUsingIntStream() {

        // IntStream avoids boxing Integer -> int
        long count =
                IntStream.of(10, 20, 30, 40, 50)
                        .count();

        System.out.println("5. IntStream count: " + count);
    }

    // ---------------------------------------------------------
    // 6. count() using Collectors.counting() (Alternative)
    // ---------------------------------------------------------
    static void countUsingCollecting() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Collectors.counting() does the same thing as count()
        long count =
                names.stream()
                        .collect(java.util.stream.Collectors.counting());

        System.out.println("6. Collectors.counting(): " + count);
    }

    // ---------------------------------------------------------
    // 7. count() on EMPTY stream (Important interview point)
    // ---------------------------------------------------------
    static void countEmptyStream() {

        List<String> empty = Arrays.asList();

        // count() on empty stream returns 0
        long count =
                empty.stream().count();

        System.out.println("7. Empty stream count: " + count);
    }

    // ---------------------------------------------------------
    // 8. count() with parallelStream()
    // ---------------------------------------------------------
    static void countParallelStream() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // count() is safe and efficient in parallel streams
        long count =
                names.parallelStream().count();

        System.out.println("8. Parallel stream count: " + count);
    }
}
