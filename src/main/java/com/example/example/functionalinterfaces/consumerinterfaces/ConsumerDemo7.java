package com.example.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Consumer;

/*
 * USE CASE:
 * - Same behavior used many times
 */
/**
 * Easy: Demonstrates Consumer Demo7 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ConsumerDemo7 {
    public static void main(String[] args) {

        // One Consumer, multiple uses
        Consumer<Integer> square = x -> System.out.println(x * x);

        square.accept(2);
        square.accept(3);
    }
}
