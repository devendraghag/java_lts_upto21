package com.example.functionalinterfaces.predicateinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Predicate;

/*
 Predicate1: Check if number is even
 Demonstrates basic test() usage
*/
/**
 * Easy: Demonstrates Predicate1 Is Even in the Functional Interfaces / Predicate Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class Predicate1_IsEven {
    public static void main(String[] args) {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(10)); // true
    }
}
