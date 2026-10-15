package org.example.lts_features.level02_intermediate.jdk8.functionalinterfaces.predicateinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiPredicate;

/*
 BiPredicate2: Compare string length
*/
/**
 * Easy: Demonstrates Bi Predicate2 String Length in the Functional Interfaces / Predicate Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class BiPredicate2_StringLength {
    public static void main(String[] args) {
        BiPredicate<String, Integer> hasLength = (s, len) -> s.length() == len;
        System.out.println(hasLength.test("Java", 4)); // true
    }
}
