package com.example.example.functionalinterfaces.binaryinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.IntBinaryOperator;

/*
 IntBinaryOperator2: Find maximum value
*/
/**
 * Easy: Demonstrates Int Binary Operator2 Max in the Functional Interfaces / Binary Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class IntBinaryOperator2Max {
    public static void main(String[] args) {
        IntBinaryOperator max = Math::max;
        System.out.println(max.applyAsInt(10, 20));
    }
}
