package com.example.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Consumer;

/*
 * USE CASE:
 * - One-time Consumer
 * - Pre-Java-8 style
 */
/**
 * Easy: Demonstrates Consumer Demo2 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ConsumerDemo2 {
    public static void main(String[] args) {

        // Anonymous class implementing Consumer
        Consumer<Integer> c = new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println(t + 100);
            }
        };

        c.accept(5);
    }
}
