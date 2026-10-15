package com.example.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiConsumer;

/*
 * USE CASE:
 * - Reusable logic
 * - OOP-style design
 */
/**
 * Easy: Demonstrates Bi Consumer Demo1 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class BiConsumerDemo1 implements BiConsumer<Integer, Integer> {

    @Override
    public void accept(Integer a, Integer b) {
        // Business logic using two inputs
        System.out.println("Sum = " + (a + b));
    }

    public static void main(String[] args) {
        new BiConsumerDemo1().accept(10, 20);
    }
}
