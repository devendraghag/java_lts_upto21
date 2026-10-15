package org.example.lts_features.level02_intermediate.jdk8.functionalinterfaces.predicateinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.DoublePredicate;

/*
 DoublePredicate1: Check fractional value
*/
/**
 * Easy: Demonstrates Double Predicate1 Is Fraction in the Functional Interfaces / Predicate Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class DoublePredicate1_IsFraction {
    public static void main(String[] args) {
        DoublePredicate isFraction = d -> d % 1 != 0;
        System.out.println(isFraction.test(10.5)); // true
    }
}
