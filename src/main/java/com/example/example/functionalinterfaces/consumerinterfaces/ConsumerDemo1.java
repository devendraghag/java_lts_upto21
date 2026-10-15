package com.example.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Consumer;

/*
 * USE CASE:
 * - When you want reusable behavior
 * - Traditional OOP approach
 */
/**
 * Easy: Demonstrates Consumer Demo1 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ConsumerDemo1 implements Consumer<Integer> {

    // accept() defines how the value is consumed
    @Override
    public void accept(Integer t) {
        // Business logic
        System.out.println(t * 2);
    }

    public static void main(String[] args) {
        // Class itself is a Consumer
        new ConsumerDemo1().accept(10);
    }
}
