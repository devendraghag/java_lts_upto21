package org.example.lts_features.level02_intermediate.jdk8.functionalinterfaces.predicateinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.LongPredicate;

/*
 LongPredicate1: Check large long value
*/
/**
 * Easy: Demonstrates Long Predicate1 Is Large in the Functional Interfaces / Predicate Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class LongPredicate1_IsLarge {
    public static void main(String[] args) {
        LongPredicate isLarge = n -> n > 1_000_000L;
        System.out.println(isLarge.test(2_000_000L)); // true
    }
}
