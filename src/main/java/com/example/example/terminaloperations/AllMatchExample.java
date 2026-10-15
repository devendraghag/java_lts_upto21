package com.example.terminaloperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * Demonstrates multiple unique ways to use Stream.allMatch()
 * Compatible with Java 8 through Java 21
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class AllMatchExample {

    // ===== Entry point =====
    public static void main(String[] args) {
        basicAllMatch();
        methodReferenceExample();
        predicateExample();
        combinedPredicateExample();
        intStreamExample();
        customObjectExample();
        parallelStreamExample();
    }

    // ---------------------------------------------------------
    // 1. BASIC allMatch (Most common and readable)
    // ---------------------------------------------------------
    static void basicAllMatch() {
        List<String> names = java.util.Arrays.asList("Alice", "Anna", "Amanda");
        // allMatch returns true only if ALL elements satisfy the condition
        boolean allStartWithA = names.stream().allMatch(name -> name.startsWith("A"));
        boolean allStartWithB = names.stream().allMatch(String::isBlank);
        System.out.println("1. check is blank: " + allStartWithB);
        System.out.println("1. Basic allMatch: " + allStartWithA);
        List<Integer> numbers = java.util.Arrays.asList(2, 4, 6, 8, 10);
        // Checks whether every number is even
        boolean allEven = numbers.stream().allMatch(num -> num % 2 == 0);
        System.out.println("   All even numbers: " + allEven);
    }

    // ---------------------------------------------------------
    // 2. Using Method References (Cleaner & reusable)
    // ---------------------------------------------------------
    static void methodReferenceExample() {
        List<String> names = java.util.Arrays.asList("Alice", "Anna", "Amanda");
        // Method reference replaces lambda for better readability
        boolean result = names.stream().allMatch(AllMatchExample::startsWithA);
        System.out.println("2. Method reference: " + result);
    }

    // Helper method for method reference
    static boolean startsWithA(String name) {
        return name.startsWith("A");
    }

    // ---------------------------------------------------------
    // 3. Using Predicate explicitly (Declarative style)
    // ---------------------------------------------------------
    static void predicateExample() {
        // Predicate represents a boolean condition
        Predicate<Integer> isEven = number -> number % 2 == 0;
        List<Integer> numbers = java.util.Arrays.asList(2, 4, 6, 8);
        // allMatch applies the predicate to every element
        boolean result = numbers.stream().allMatch(isEven);
        System.out.println("3. Predicate example: " + result);
    }

    // ---------------------------------------------------------
    // 4. Combining Predicates (Business rule validation)
    // ---------------------------------------------------------
    static void combinedPredicateExample() {
        Predicate<String> startsWithA = s -> s.startsWith("A");
        Predicate<String> longerThan3 = s -> s.length() > 3;
        List<String> names = java.util.Arrays.asList("Alice", "Amanda", "Andrew");
        // Predicate.and() combines multiple conditions
        boolean result = names.stream().allMatch(startsWithA.and(longerThan3)); // new thing
        boolean results = names.stream().allMatch(s -> s.startsWith("A") && s.length() > 3); // Equivalent to new thing
        System.out.println("4. Combined predicates: " + result);
        System.out.println("4. Combined predicates: " + results);
    }

    // ---------------------------------------------------------
    // 5. Using IntStream (Performance-oriented)
    // ---------------------------------------------------------
    static void intStreamExample() {
        // IntStream avoids boxing (Integer -> int)
        boolean allEven = IntStream.of(2, 4, 6, 8, 10).allMatch(n -> n % 2 == 0);
        System.out.println("5. IntStream example: " + allEven);
    }

    // ---------------------------------------------------------
    // 6. Using a custom object
    // ---------------------------------------------------------
    static void customObjectExample() {
        List<Person> people = java.util.Arrays.asList(
                new Person("Alice"),
                new Person("Anna"),
                new Person("Amanda")
        );
        boolean result = people.stream().allMatch(p -> p.getName().startsWith("A"));
        System.out.println("6. Custom object example: " + result);
    }

    // ---------------------------------------------------------
    // 7. Parallel Stream (Large data sets only)
    // ---------------------------------------------------------
    static void parallelStreamExample() {
        List<Integer> numbers = java.util.Arrays.asList(2, 4, 6, 8, 10);
        // parallelStream processes elements in parallel threads
        // allMatch is safe because it is stateless and short-circuiting
        boolean result = numbers.parallelStream().allMatch(n -> n % 2 == 0);
        System.out.println("7. Parallel stream: " + result);
    }

    static class Person {
        private final String name;

        Person(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }
    }
}
