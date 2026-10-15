package com.example.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Consumer;

/*
 * USE CASE:
 * - Multiple actions on same input
 */
/**
 * Easy: Demonstrates Consumer Demo8 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ConsumerDemo8 {
    public static void main(String[] args) {

        Consumer<Integer> c1 = x -> System.out.println("Value: " + x);
        Consumer<Integer> c2 = x -> System.out.println("Times 10: " + x * 10);

        // c1 runs first, then c2
        c1.andThen(c2).accept(3);
    }
}
