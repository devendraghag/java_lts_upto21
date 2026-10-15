package com.example.intermediateoperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates peek() triggering only when a TERMINAL operation exists.
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class PeekExample {

    public static void main(String[] args) {

        peekWithCount();
        peekWithoutTerminal();
        peekVsForEach();
    }

    // ---------------------------------------------------------
    // 1. peek() + terminal operation (Your original example)
    // ---------------------------------------------------------
    static void peekWithCount() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        long count =
                names.stream()
                        .peek(System.out::println) // debugging
                        .count();                  // terminal op

        System.out.println("Count: " + count);
    }

    // ---------------------------------------------------------
    // 2. peek() WITHOUT terminal operation (Does NOTHING)
    // ---------------------------------------------------------
    static void peekWithoutTerminal() {

        List<String> names = Arrays.asList("Alice", "Bob");

        names.stream()
                .peek(System.out::println); // ❌ never executed
    }

    // ---------------------------------------------------------
    // 3. peek() vs forEach()
    // ---------------------------------------------------------
    static void peekVsForEach() {

        List<String> names = Arrays.asList("Alice", "Bob");

        System.out.println("peek():");
        names.stream()
                .peek(System.out::println)
                .count();

        System.out.println("forEach():");
        names.forEach(System.out::println);
    }
}