package com.example.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Consumer;

/*
 * USE CASE:
 * - Modern Java
 * - Clean and concise
 */
/**
 * Easy: Demonstrates Consumer Demo3 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ConsumerDemo3 {
    public static void main(String[] args) {

        // Lambda represents accept(t)
        Consumer<Integer> c = t -> System.out.println(t - 1);

        c.accept(20);
    }
}
