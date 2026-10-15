package org.example.lts_features.level02_intermediate.jdk8.functionalinterfaces.predicateinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Predicate;

/*
 Predicate4: Using and() to combine predicates
*/
/**
 * Easy: Demonstrates Predicate4 And Composition in the Functional Interfaces / Predicate Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class Predicate4_AndComposition {
    public static void main(String[] args) {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isGreaterThan10 = n -> n > 10;

        Predicate<Integer> combined = isEven.and(isGreaterThan10);
        System.out.println(combined.test(12)); // true
    }
}
