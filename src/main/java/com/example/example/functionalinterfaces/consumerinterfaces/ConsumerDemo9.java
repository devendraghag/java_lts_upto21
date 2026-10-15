package com.example.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.List;

/*
 * USE CASE:
 * - Processing collections
 */
/**
 * Easy: Demonstrates Consumer Demo9 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ConsumerDemo9 {
    public static void main(String[] args) {

        List<Integer> list = java.util.Arrays.asList(1, 2, 3);

        // forEach internally calls accept()
        list.forEach(x -> System.out.println(x));
    }
}
