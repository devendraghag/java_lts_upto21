package com.example.terminaloperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates terminal operation forEach().
 * forEach() does NOT guarantee order in parallel streams.
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ForEachExample {

    public static void main(String[] args) {

        basicForEach();
        forEachWithLambda();
        forEachWithParallelStream();
    }

    // ---------------------------------------------------------
    // 1. BASIC forEach() (Your original example)
    // ---------------------------------------------------------
    static void basicForEach() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        names.stream()
                .forEach(System.out::println);
    }

    // ---------------------------------------------------------
    // 2. forEach() using lambda
    // ---------------------------------------------------------
    static void forEachWithLambda() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        names.stream()
                .forEach(name ->
                        System.out.println("Hello " + name));
    }

    // ---------------------------------------------------------
    // 3. forEach() with PARALLEL stream (order NOT guaranteed)
    // ---------------------------------------------------------
    static void forEachWithParallelStream() {

        List<String> names = Arrays.asList("A", "B", "C", "D");

        names.parallelStream()
                .forEach(System.out::print);

        System.out.println("\nOrder may vary above");
    }
}
