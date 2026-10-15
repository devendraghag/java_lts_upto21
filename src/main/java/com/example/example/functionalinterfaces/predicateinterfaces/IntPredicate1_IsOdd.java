package org.example.lts_features.level02_intermediate.jdk8.functionalinterfaces.predicateinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.IntPredicate;

/*
 IntPredicate1: Check odd number
*/
/**
 * Easy: Demonstrates Int Predicate1 Is Odd in the Functional Interfaces / Predicate Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class IntPredicate1_IsOdd {
    public static void main(String[] args) {
        IntPredicate isOdd = n -> n % 2 != 0;
        System.out.println(isOdd.test(7)); // true
    }
}
