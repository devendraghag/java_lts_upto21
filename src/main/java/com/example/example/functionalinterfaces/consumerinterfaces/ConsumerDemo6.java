package com.example.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Consumer;

/*
 * USE CASE:
 * - Passing behavior as argument
 * - Functional programming
 */
/**
 * Easy: Demonstrates Consumer Demo6 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ConsumerDemo6 {

    static void process(Integer t, Consumer<Integer> c) {
        // Execute behavior
        c.accept(t);
    }

    public static void main(String[] args) {

        process(5, x -> System.out.println(x * x));
    }
}