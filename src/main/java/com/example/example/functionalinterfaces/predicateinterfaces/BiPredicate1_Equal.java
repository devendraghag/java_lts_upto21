package org.example.lts_features.level02_intermediate.jdk8.functionalinterfaces.predicateinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiPredicate;

/*
 BiPredicate1: Compare two integers for equality
*/
/**
 * Easy: Demonstrates Bi Predicate1 Equal in the Functional Interfaces / Predicate Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class BiPredicate1_Equal {
    public static void main(String[] args) {
        BiPredicate<Integer, Integer> isEqual = (a, b) -> a.equals(b);
        System.out.println(isEqual.test(5, 5)); // true
    }
}
