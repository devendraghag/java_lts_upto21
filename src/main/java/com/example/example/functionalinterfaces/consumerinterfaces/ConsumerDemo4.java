package com.example.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Consumer;

/*
 * USE CASE:
 * - Reuse existing static method
 */
/**
 * Easy: Demonstrates Consumer Demo4 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ConsumerDemo4 {

    // Existing method ,static method reference
    static void show(Integer t) {
        System.out.println(t);
    }

    public static void main(String[] args) {

        // accept(t) → show(t)
        Consumer<Integer> c = ConsumerDemo4::show;

        c.accept(30);
    }
}
