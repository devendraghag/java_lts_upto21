package com.example.terminaloperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * Demonstrates multiple unique ways to use Stream.anyMatch()
 * Works from Java 8 to Java 21
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class AnyMatchExample {

    public static void main(String[] args) {

        basicAnyMatch();
        methodReferenceExample();
        predicateExample();
        combinedPredicateExample();
        intStreamExample();
        parallelStreamExample();
        emptyStreamBehavior();
    }

    // ---------------------------------------------------------
    // 1. BASIC anyMatch (Most common usage)
    // ---------------------------------------------------------
    static void basicAnyMatch() {

        List<String> names = java.util.Arrays.asList("Alice", "Bob", "Charlie");
        // anyMatch returns true if AT LEAST ONE element matches the condition
        boolean result = names.stream().anyMatch(name -> name.startsWith("A"));
        System.out.println("1. Basic anyMatch (startsWith A): " + result);
        List<Integer> numbers = java.util.Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18, 20);
        // Checks whether at least one number is divisible by 21
        boolean divisibleBy21 = numbers.stream().anyMatch(num -> num % 21 == 0);
        System.out.println("   Any number divisible by 21: " + divisibleBy21);
    }

    // ---------------------------------------------------------
    // 2. Using Method Reference (Cleaner & reusable)
    // ---------------------------------------------------------
    static void methodReferenceExample() {

        List<String> names = java.util.Arrays.asList("Alice", "Bob", "Charlie");
        // Method reference instead of lambda
        boolean result = names.stream().anyMatch(AnyMatchExample::startsWithA);
        System.out.println("2. Method reference example: " + result);
    }

    // Helper method used as method reference
    static boolean startsWithA(String name) {
        return name.startsWith("A");
    }

    // ---------------------------------------------------------
    // 3. Using Predicate explicitly (Declarative style)
    // ---------------------------------------------------------
    static void predicateExample() {

        // Predicate represents a boolean condition
        Predicate<Integer> divisibleBy21 = n -> n % 21 == 0;
        List<Integer> numbers = java.util.Arrays.asList(10, 15, 21, 25);
        // anyMatch applies predicate until it finds a match
        boolean result = numbers.stream().anyMatch(divisibleBy21);
        System.out.println("3. Predicate example: " + result);
    }

    // ---------------------------------------------------------
    // 4. Combining Predicates (Business-rule validation)
    // ---------------------------------------------------------
    static void combinedPredicateExample() {

        Predicate<String> startsWithA = s -> s.startsWith("A");
        Predicate<String> lengthGreaterThan3 = s -> s.length() > 3;
        List<String> names = java.util.Arrays.asList("Al", "Bob", "Amanda");
        // At least ONE element must satisfy BOTH conditions
        boolean result = names.stream().anyMatch(startsWithA.and(lengthGreaterThan3));
        System.out.println("4. Combined predicate (AND): " + result);
        // OR condition: at least one condition must be true
        boolean orResult = names.stream().anyMatch(startsWithA.or(lengthGreaterThan3));
        System.out.println("   Combined predicate (OR): " + orResult);
    }

    // ---------------------------------------------------------
    // 5. Using IntStream (Performance-oriented)
    // ---------------------------------------------------------
    static void intStreamExample() {
        // IntStream avoids boxing Integer -> int
        boolean result = IntStream.of(1, 3, 5, 7, 8).anyMatch(n -> n % 2 == 0);
        System.out.println("5. IntStream example (any even): " + result);
    }

    // ---------------------------------------------------------
    // 6. Parallel Stream (Large data sets only)
    // ---------------------------------------------------------
    static void parallelStreamExample() {

        List<Integer> numbers = java.util.Arrays.asList(2, 4, 6, 7, 8, 10);
        // parallelStream processes elements concurrently
        // anyMatch is safe because it is stateless and short-circuiting
        boolean result = numbers.parallelStream().anyMatch(n -> n % 2 != 0);
        System.out.println("6. Parallel stream example: " + result);
    }

    // ---------------------------------------------------------
    // 7. Empty Stream behavior (Important interview point)
    // ---------------------------------------------------------
    static void emptyStreamBehavior() {

        List<String> empty = java.util.Arrays.asList();
        // anyMatch on empty stream ALWAYS returns false
        boolean result = empty.stream().anyMatch(s -> s.startsWith("A"));
        System.out.println("7. Empty stream behavior: " + result);
    }
}
