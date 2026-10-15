package org.example.lts_features.level02_intermediate.jdk8.functionalinterfaces.predicateinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Predicate;

/*
 Predicate3: Validate string not empty
*/
/**
 * Easy: Demonstrates Predicate3 String Not Empty in the Functional Interfaces / Predicate Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class Predicate3_StringNotEmpty {
    public static void main(String[] args) {
        Predicate<String> notEmpty = s -> s != null && !s.isEmpty();
        System.out.println(notEmpty.test("Java")); // true
    }
}
