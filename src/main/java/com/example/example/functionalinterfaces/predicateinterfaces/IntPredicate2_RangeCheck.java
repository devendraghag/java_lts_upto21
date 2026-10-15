package org.example.lts_features.level02_intermediate.jdk8.functionalinterfaces.predicateinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.IntPredicate;

/*
 IntPredicate2: Check number in range
*/
/**
 * Easy: Demonstrates Int Predicate2 Range Check in the Functional Interfaces / Predicate Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class IntPredicate2_RangeCheck {
    public static void main(String[] args) {
        IntPredicate inRange = n -> n >= 1 && n <= 100;
        System.out.println(inRange.test(50)); // true
    }
}
