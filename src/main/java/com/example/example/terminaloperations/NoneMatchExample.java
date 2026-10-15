package com.example.terminaloperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates terminal operation noneMatch().
 * noneMatch() returns true if NO elements match the predicate.
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class NoneMatchExample {

    public static void main(String[] args) {

        basicNoneMatch();
        noneMatchWithFilterLogic();
        noneMatchEmptyStream();
        noneMatchParallelStream();
        noneMatchVsAnyMatch();
    }

    // ---------------------------------------------------------
    // 1. BASIC noneMatch() (Your original example)
    // ---------------------------------------------------------
    static void basicNoneMatch() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        boolean result =
                names.stream().noneMatch(name -> name.startsWith("Z"));

        System.out.println("1. No name starts with Z? " + result);
    }

    // ---------------------------------------------------------
    // 2. noneMatch() with complex condition
    // ---------------------------------------------------------
    static void noneMatchWithFilterLogic() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        boolean result =
                names.stream().noneMatch(name -> name.length() < 3);

        System.out.println("2. No short names? " + result);
    }

    // ---------------------------------------------------------
    // 3. noneMatch() on EMPTY stream (Important!)
    // ---------------------------------------------------------
    static void noneMatchEmptyStream() {

        List<String> empty = Arrays.asList();

        // noneMatch returns TRUE for empty streams
        boolean result =
                empty.stream().noneMatch(s -> s.startsWith("A"));

        System.out.println("3. Empty stream noneMatch: " + result);
    }

    // ---------------------------------------------------------
    // 4. noneMatch() with PARALLEL stream
    // ---------------------------------------------------------
    static void noneMatchParallelStream() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        boolean result =
                names.parallelStream().noneMatch(name -> name.startsWith("Z"));

        System.out.println("4. Parallel noneMatch: " + result);
    }

    // ---------------------------------------------------------
    // 5. noneMatch() vs anyMatch()
    // ---------------------------------------------------------
    static void noneMatchVsAnyMatch() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        boolean none =
                names.stream().noneMatch(name -> name.startsWith("Z"));

        boolean any =
                names.stream().anyMatch(name -> name.startsWith("Z"));

        System.out.println("5. noneMatch: " + none);
        System.out.println("   anyMatch : " + any);
    }
}
