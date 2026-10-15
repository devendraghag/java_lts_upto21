package org.example.lts_features.level02_intermediate.jdk8.functionalinterfaces.predicateinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Predicate;

/*
 Predicate2: Check if number is positive
*/
/**
 * Easy: Demonstrates Predicate2 Is Positive in the Functional Interfaces / Predicate Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class Predicate2_IsPositive {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = n -> n > 0;
        System.out.println(isPositive.test(-5)); // false
    }
}
