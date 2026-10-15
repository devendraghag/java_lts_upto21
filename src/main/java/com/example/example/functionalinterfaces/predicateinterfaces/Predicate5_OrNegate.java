package org.example.lts_features.level02_intermediate.jdk8.functionalinterfaces.predicateinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Predicate;

/*
 Predicate5: Using or() and negate()
*/
/**
 * Easy: Demonstrates Predicate5 Or Negate in the Functional Interfaces / Predicate Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class Predicate5_OrNegate {
    public static void main(String[] args) {
        Predicate<Integer> isNegative = n -> n < 0;
        Predicate<Integer> isZero = n -> n == 0;

        Predicate<Integer> result = isNegative.or(isZero).negate();
        System.out.println(result.test(5)); // true
    }
}
