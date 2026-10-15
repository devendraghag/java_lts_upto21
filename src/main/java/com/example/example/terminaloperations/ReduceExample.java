package com.example.terminaloperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Demonstrates reduce() terminal operation.
 * Shows summation, max selection, and Optional usage.
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ReduceExample {

    public static void main(String[] args) {

        basicSum();
        longestString();
        reduceWithoutIdentity();
        reduceParallel();
    }

    // ---------------------------------------------------------
    // 1. BASIC reduce() – Sum (Your original example)
    // ---------------------------------------------------------
    static void basicSum() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        int sum =
                numbers.stream()
                        .reduce(0, Integer::sum);

        System.out.println("1. Sum: " + sum); // 10
    }

    // ---------------------------------------------------------
    // 2. reduce() to find LONGEST string
    // ---------------------------------------------------------
    static void longestString() {

        List<String> words =
                Arrays.asList("apple", "banana", "pear", "watermelon");

        String longest =
                words.stream()
                        .reduce("", (w1, w2) ->
                                w1.length() > w2.length() ? w1 : w2);

        System.out.println("2. Longest word: " + longest);
    }

    // ---------------------------------------------------------
    // 3. reduce() WITHOUT identity (Returns Optional)
    // ---------------------------------------------------------
    static void reduceWithoutIdentity() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        Optional<Integer> sum =
                numbers.stream()
                        .reduce(Integer::sum);

        System.out.println("3. Optional sum: " + sum);
    }

    // ---------------------------------------------------------
    // 4. reduce() with PARALLEL stream
    // ---------------------------------------------------------
    static void reduceParallel() {

        int sum =
                Arrays.asList(1, 2, 3, 4)
                        .parallelStream()
                        .reduce(0, Integer::sum);

        System.out.println("4. Parallel reduce sum: " + sum);
    }
}