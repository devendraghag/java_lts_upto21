package org.example.lts_features.level02_intermediate.jdk8.functionalinterfaces.predicateinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiPredicate;

/*
 BiPredicate3: Using and() combination
*/
/**
 * Easy: Demonstrates Bi Predicate3 And in the Functional Interfaces / Predicate Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class BiPredicate3_And {
    public static void main(String[] args) {
        BiPredicate<Integer, Integer> bothPositive =
            (a, b) -> a > 0 && b > 0;

        System.out.println(bothPositive.test(5, 3)); // true
    }
}
